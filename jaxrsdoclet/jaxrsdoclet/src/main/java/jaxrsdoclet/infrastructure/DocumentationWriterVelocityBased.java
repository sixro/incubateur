package jaxrsdoclet.infrastructure;

import java.io.*;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.*;
import org.apache.velocity.exception.*;

import jaxrsdoclet.domain.*;

public class DocumentationWriterVelocityBased implements DocumentationWriter {

	private final String destinationDir;
	private final String templatePath;
	
	/**
	 * @deprecated We need to receive destination dir and others params, 'cause by default the dest dir is target/site/apidocs
	 */
	// FIXME to delete
	public DocumentationWriterVelocityBased() {
		this("/home/rsimoni/Development/projects/sixro/incubateur/jaxrsdoclet/sample-project/src/main/webapp", null);
	}

	public DocumentationWriterVelocityBased(String destinationDir, String templatePath) {
		super();
		this.destinationDir = destinationDir;
		this.templatePath = templatePath;
	}

	@Override
	public void write(CodeDocumentation codeDoc) {
		try {
			Velocity.init();
			
			VelocityContext context = new VelocityContext();
			context.put("codeDoc", codeDoc);
			
			InputStreamReader templateReader = new InputStreamReader(DocumentationWriterVelocityBased.class.getResourceAsStream("/default-template.vm"));
			Writer writer = new PrintWriter(new File(destinationDir, "index.html"));
			boolean evaluated = Velocity.evaluate(context, writer, "jaxrsDoclet", templateReader);
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException("Unable to write JAX-RS documentation due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

}
