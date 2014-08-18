package databaseadapter;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * Echos an object string to the output screen.
 * 
 * @goal generate
 * @phase generate-sources
 * 
 * @requiresDependencyResolution runtime
 * @requiresProject false
 */
public class GenerateMojo extends AbstractMojo {

	/**
	 * @parameter default-value="${project}"
	 * @required
	 * @readonly
	 */
	private MavenProject project;
	
	/**
	 * Represents the JDBC driver class name to load.
	 * 
	 * @parameter expression="${generate.driverClass}"
	 * @required
	 */
	private String driverClass;
	
	/**
	 * Represents the URL of the database.
	 * 
	 * @parameter expression="${generate.url}"
	 * @required
	 */
	private String url;

	/**
	 * Represents the username to use in order to connect to the database..
	 * 
	 * @parameter expression="${generate.username}"
	 */
	private String username;

	/**
	 * Represents the password to use in order to connect to the database..
	 * 
	 * @parameter expression="${generate.password}"
	 */
	private String password;
	
	/**
	 * Represents other connection properties to use.
	 * <p>
	 * They dependes strictly on JDBC driver.
	 * </p>
	 * 
	 * @parameter
	 */
	private Properties connectionProperties;
	
	/**
	 * Represents the pattern of the schema(s) to read (e.g. {@code MYSCH%}).
	 * 
	 * @parameter expression="${generate.schemaPattern}" default-value="%"
	 */
	private String schemaPattern;
	
	/**
	 * Represents the patterns to use in order to include tables in the process.
	 * 
	 * @parameter alias="includes"
	 */
	private String[] includes;

	/**
	 * Represents the patterns to use in order to exclude tables in the process.
	 * 
	 * @parameter alias="excludes"
	 */
	private String[] excludes;

	/**
	 * Represents the templates to use to generate code.
	 * 
	 * @parameter alias="templates"
	 */
	private Template[] templates;
	
	private Connection connection;
	
	public GenerateMojo() {
		super();
	}

	GenerateMojo(String driverClass, String url, String username, String password, String schemaPattern, String[] includes, String[] excludes, Template[] templates) throws MojoExecutionException {
		super();
		this.driverClass = driverClass;
		this.url = url;
		this.username = username;
		this.password = password;
		this.schemaPattern = schemaPattern;
		this.includes = includes;
		this.excludes = excludes;
		this.templates = templates;
		
		initialize();
	}

	public void execute() throws MojoExecutionException, MojoFailureException {
		initialize();
		
		Collection<Table> tables = collectTables();
		Map<Table, List<Column>> tablesColumns = collectColumns(tables);

		for (Map.Entry<Table, List<Column>> entry : tablesColumns.entrySet()) {
			Table table = entry.getKey();
			List<Column> columns = entry.getValue();
			table.setColumns(columns);

			getLog().debug("... table " + table + ":");
			for (Column col : columns)
				getLog().debug("    \\--> column " + col);
		}
		
		for (Template template : templates) {
			if (template.isForeach())
				for (Table table : tables) {
					String code = generateCode(table, template);
					File outputDirectory = template.getOutputDirectory();
					if (outputDirectory == null) {
						outputDirectory = new File(project.getBuild().getDirectory(), "generated-sources");
						outputDirectory = new File(outputDirectory, "databaseadapter");
					}
					
					String[] subfolders = StringUtils.split(template.getPackage(), '.');
					for (String subfolder : subfolders)
						outputDirectory = new File(outputDirectory, subfolder);
					
					if (! outputDirectory.exists()) outputDirectory.mkdirs();
					File outputFile = new File(outputDirectory, tableToClassName(table, template) + ".java");
					try {
						FileUtils.writeStringToFile(outputFile, code);
					} catch (IOException e) {
						throw new RuntimeException("Unable to write generated code into file '" + outputFile + "' due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
					}
				}
			else {
				String code = generateCode(tables, template);
				File outputDirectory = template.getOutputDirectory();
				if (outputDirectory == null) {
					outputDirectory = new File(project.getBuild().getDirectory(), "generated-sources");
					outputDirectory = new File(outputDirectory, "databaseadapter");
				}
				
				String[] subfolders = StringUtils.split(template.getPackage(), '.');
				for (String subfolder : subfolders)
					outputDirectory = new File(outputDirectory, subfolder);
				
				if (! outputDirectory.exists()) outputDirectory.mkdirs();
				File outputFile = new File(outputDirectory, template.getClassName() + ".java");
				try {
					FileUtils.writeStringToFile(outputFile, code);
				} catch (IOException e) {
					throw new RuntimeException("Unable to write generated code into file '" + outputFile + "' due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
				}
			}
		}
	}

	private void initialize() throws MojoExecutionException {
		Validate.notEmpty(driverClass, "'driverClass' parameter is required");
		Validate.notEmpty(url, "'url' parameter is required");
		Validate.notEmpty(templates, "'templates' parameter is required");
		
		if (templates != null) {
			for (Template template : templates) {
				getLog().info(template.toString());
			}
		}
		
		getLog().info("Generating database adapter classes against database at URL '" + url + "'...");
		getLog().debug("... connecting using driver '" + driverClass + "' and credentials [" + username + "/" + password + "]...");
		
		loadJDBCDriver();
		connection = newConnection();
	}

	protected Collection<Table> collectTables() throws MojoExecutionException {
		ResultSet rstables = null;
		try {
			List<Table> tables = new LinkedList<Table>();
			DatabaseMetaData metaData = connection.getMetaData();
			rstables = metaData.getTables(null, schemaPattern, "%", new String[]{ "TABLE" });
			while (rstables.next()) {
				String schema = rstables.getString("TABLE_SCHEM");
				String table = rstables.getString("TABLE_NAME");
				String type = rstables.getString("TABLE_TYPE");
				String remarks = rstables.getString("REMARKS");
				getLog().debug("... found table " + schema + "." + table + " (" + type + ")...");
				if (isToInclude(table)) {
					if (! isToExclude(table)) {
						getLog().debug("... processing...");
						Table t = new Table(table, remarks);
						tables.add(t);
						
					} else {
						getLog().debug("... skipping due to 'excludes' pattern(s)");
					}
				} else {
					getLog().debug("... skipping due to 'includes' pattern(s)");
				}
			}
			
			getLog().info("... found to process " + tables.size() + " tables: " + tables);
			return tables;
		} catch (SQLException e) {
			throw new MojoExecutionException("Unable to generate database adapter due to a '" + e.getClass().getName() + "' with message '" + e.getMessage() + "'", e);
		} finally {
			if (rstables != null) { try { rstables.close(); } catch (SQLException ignore) { } }
		}
	}

	protected Map<Table, List<Column>> collectColumns(Collection<Table> tables) throws MojoExecutionException {
		ResultSet rscolumns = null;
		try {
			Map<Table, List<Column>> map = new LinkedHashMap<Table, List<Column>>();
			DatabaseMetaData metaData = connection.getMetaData();
			rscolumns = metaData.getColumns(null, schemaPattern, "%", "%");
			while (rscolumns.next()) {
				String tableName = rscolumns.getString("TABLE_NAME");
				Table table = find(tables, tableName);
				if (table == null) continue;
				
				List<Column> columns = map.get(table);
				if (columns == null) {
					columns = new LinkedList<Column>();
					map.put(table, columns);
				}

				String columnName = rscolumns.getString("COLUMN_NAME");
				int dataType = rscolumns.getInt("DATA_TYPE");
				int columnSize = rscolumns.getInt("COLUMN_SIZE");
				int decimalDigits = rscolumns.getInt("DECIMAL_DIGITS");
				int nullable = rscolumns.getInt("NULLABLE");
				String remarks = rscolumns.getString("REMARKS");
				
				Column column = new Column(columnName, dataType, columnSize, decimalDigits, nullable == DatabaseMetaData.columnNullable, remarks);
				columns.add(column);
			}
			
			return map;
		} catch (SQLException e) {
			throw new MojoExecutionException("Unable to generate database adapter due to a '" + e.getClass().getName() + "' with message '" + e.getMessage() + "'", e);
		} finally {
			if (rscolumns != null) { try { rscolumns.close(); } catch (SQLException ignore) { } }
		}
	}

	protected String generateCode(Collection<Table> tables, Template template) {
		try {
			VelocityContext context = new VelocityContext();
			context.put("package", template.getPackage());
			context.put("className", template.getClassName());
			context.put("tables", tables);
			context.put("stringUtils", new databaseadapter.StringUtils());
			
			StringWriter writer = new StringWriter();
			Velocity.evaluate(context, writer, "databaseadapter-" + template.getClassName(), new FileReader(template.getSource()));
			return writer.toString();
		} catch (ParseErrorException e) {
			throw new RuntimeException("unexpected error", e);
		} catch (MethodInvocationException e) {
			throw new RuntimeException("unexpected error", e);
		} catch (ResourceNotFoundException e) {
			throw new RuntimeException("unexpected error", e);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("unexpected error", e);
		}
	}

	protected String generateCode(Table table, Template template) {
		try {
			VelocityContext context = new VelocityContext();
			context.put("package", template.getPackage());
			context.put("table", table);
			context.put("stringUtils", new databaseadapter.StringUtils());
			
			String className = tableToClassName(table, template);
			context.put("className", className);
			
			StringWriter writer = new StringWriter();
			Velocity.evaluate(context, writer, "databaseadapter-" + className, new FileReader(template.getSource()));
			return writer.toString();
		} catch (ParseErrorException e) {
			throw new RuntimeException("unexpected error", e);
		} catch (MethodInvocationException e) {
			throw new RuntimeException("unexpected error", e);
		} catch (ResourceNotFoundException e) {
			throw new RuntimeException("unexpected error", e);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("unexpected error", e);
		}
	}

	private Table find(Collection<Table> tables, String tableName) {
		for (Table table : tables)
			if (table.named(tableName)) return table;
		return null;
	}

	private void loadJDBCDriver() throws MojoExecutionException {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new MojoExecutionException("Unable to find a JDBC driver class named '" + driverClass + "'. Please check configuration of databaseadapter-maven-plugin", e);
		}
	}

	@SuppressWarnings("unchecked")
	private Connection newConnection() throws MojoExecutionException {
		try {
			Properties props = new Properties();
			props.setProperty("user", username);
			props.setProperty("password", password);
			if (connectionProperties != null) {
				Enumeration<String> propertyNames = (Enumeration<String>) connectionProperties.propertyNames();
				while (propertyNames.hasMoreElements()) {
					String property = propertyNames.nextElement();
					props.setProperty(property, connectionProperties.getProperty(property));
				}
			}
			return DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			throw new MojoExecutionException("Unable to get a database connection using URL '" + url + "' and credentials [" + username + "/" + password + "]. Please check configuration of databaseadapter-maven-plugin", e);
		}
	}

	private boolean isToInclude(String table) {
		if (includes == null || includes.length == 0)
			return true;

		for (String regex : includes) {
			getLog().debug("... checking table '" + table + "' against regex '" + regex + "' in order to check if it is to be included...");
			
			Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(table);
			if (matcher.matches()) return true;
		}
		
		return false;
	}

	private boolean isToExclude(String table) {
		if (excludes == null || excludes.length == 0)
			return false;

		for (String regex : excludes) {
			getLog().debug("... checking table '" + table + "' against regex '" + regex + "' in order to check if it is to be excluded...");
			
			Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(table);
			if (matcher.matches()) return true;
		}
		
		return false;
	}

	private String tableToClassName(Table table, Template template) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", table.getName());
		map.put("tableNameAsCamelCase", databaseadapter.StringUtils.toCamelCase(table.getName()));
		String className = StrSubstitutor.replace(template.getClassName(), map);
		return className;
	}

}
