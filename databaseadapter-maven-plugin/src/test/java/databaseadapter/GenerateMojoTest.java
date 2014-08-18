package databaseadapter;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;

public class GenerateMojoTest {

	private static final Template[] USELESS_TEMPLATES_FOR_TEST_PURPOSE = new Template[]{ new Template("app.unittest", "DB", new File("xxx.vm"), null) };

	@Test public void collectTables_returns2Tables() throws MojoExecutionException {
		GenerateMojo generateMojo = new GenerateMojo("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@10.0.0.46:1551:ORA10A", "DIPMASTER", "DIPMASTER", "DIPMASTER", new String[]{ "CDC_CROCIERA", "CDC_DEPLOYMENT" }, null, USELESS_TEMPLATES_FOR_TEST_PURPOSE);
		Collection<Table> tables = generateMojo.collectTables();
		assertEquals(2, tables.size());
	}

	@Test public void collectColumns_returns20Columns() throws MojoExecutionException {
		GenerateMojo generateMojo = new GenerateMojo("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@10.0.0.46:1551:ORA10A", "DIPMASTER", "DIPMASTER", "DIPMASTER", new String[]{ "CDC_CROCIERA", "CDC_DEPLOYMENT" }, null, USELESS_TEMPLATES_FOR_TEST_PURPOSE);
		Map<Table, List<Column>> tablesColumns = generateMojo.collectColumns(Arrays.asList(new Table("CDC_CROCIERA")));
		assertEquals(20, tablesColumns.values().iterator().next().size());
	}

	@Test public void generateCode_returnsAText() throws MojoExecutionException, IOException {
		File source = new File(SystemUtils.JAVA_IO_TMPDIR, "my-template.vm");
		if (source.exists()) source.delete();
		FileUtils.writeStringToFile(source, "package ${package};\n\npublic class ${className} {\n\n}");
		
		Table table = new Table("CDC_CROCIERA");
		table.setColumns(Arrays.asList(new Column("NAME", 3, 20, 2, true)));
		
		GenerateMojo generateMojo = new GenerateMojo("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@10.0.0.46:1551:ORA10A", "DIPMASTER", "DIPMASTER", "DIPMASTER", new String[]{ "CDC_CROCIERA", "CDC_DEPLOYMENT" }, null, USELESS_TEMPLATES_FOR_TEST_PURPOSE);
		String code = generateMojo.generateCode(Arrays.asList(table), new Template("testingapp", "DB", source, null));
		assertTrue(code.contains("testingapp"));
		assertTrue(code.contains("DB"));
	}

	@Test public void generateCode_whitASingleTableReturnsATextContainingAFormattedClassname() throws MojoExecutionException, IOException {
		File source = new File(SystemUtils.JAVA_IO_TMPDIR, "my-template.vm");
		if (source.exists()) source.delete();
		FileUtils.writeStringToFile(source, "package ${package};\n\npublic class ${className} {\n\n}");
		
		Table table = new Table("CDC_CROCIERA");
		table.setColumns(Arrays.asList(new Column("NAME", 3, 20, 2, true)));
		
		GenerateMojo generateMojo = new GenerateMojo("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@10.0.0.46:1551:ORA10A", "DIPMASTER", "DIPMASTER", "DIPMASTER", new String[]{ "CDC_CROCIERA", "CDC_DEPLOYMENT" }, null, USELESS_TEMPLATES_FOR_TEST_PURPOSE);
		String code = generateMojo.generateCode(table, new Template(true /*foreach*/, "testingapp", "${tableNameAsCamelCase}Table", source, null));
		System.out.println(code);
		assertTrue(code.contains("CdcCrocieraTable"));
	}

}
