package jaxrsdoclet.infrastructure;

import java.util.Map;

import jaxrsdoclet.domain.DocumentationWriter;

public class DocumentationWriterVelocityBased implements DocumentationWriter {

	@Override
	public void write(Map<String, Object> codeDocumentation) {
		System.out.println(codeDocumentation);
	}

}
