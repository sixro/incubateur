package databaseadapter;

import java.io.File;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Template {

	/**
	 * When {@code true} call the template for each table found.
	 * 
	 * @parameter alias="foreach" default-value="false"
	 */
	private boolean foreach;

	private String package_;
	
	/**
	 * Represents the className.
	 * 
	 * @parameter alias="className"
	 */
	private String className;

	/**
	 * Represents the source of the template.
	 * 
	 * @parameter alias="source"
	 */
	private File source;

	/**
	 * Represents the output directory.
	 * 
	 * @parameter alias="outputDirectory" expression="${project.build.directory}/generated-sources/databaseadapter" default-value="${project.build.directory}/generated-sources/databaseadapter"
	 */
	private File outputDirectory;
	
	public Template() {
		super();
	}

	Template(String package_, String className, File source, File outputDirectory) {
		super();
		this.package_ = package_;
		this.className = className;
		this.source = source;
		this.outputDirectory = outputDirectory;
	}

	Template(boolean foreach, String package_, String className, File source, File outputDirectory) {
		super();
		this.foreach = foreach;
		this.package_ = package_;
		this.className = className;
		this.source = source;
		this.outputDirectory = outputDirectory;
	}

	public String getPackage() {
		return package_;
	}

	/**
	 * Represents the package of the generated code.
	 * 
	 * @parameter alias="package"
	 */
	public void setPackage(String package_) {
		this.package_ = package_;
	}

	public String getClassName() {
		return className;
	}

	public File getSource() {
		return source;
	}

	public File getOutputDirectory() {
		return outputDirectory;
	}

	public boolean isForeach() {
		return foreach;
	}

	public void setForeach(boolean foreach) {
		this.foreach = foreach;
	}

	@Override public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
