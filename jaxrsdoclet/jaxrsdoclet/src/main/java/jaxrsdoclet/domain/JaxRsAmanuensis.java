package jaxrsdoclet.domain;

import java.util.Map;

/**
 * Represents the &quot;amanuensis&quot; reading documentation in javadoc and writing it in output.
 */
public class JaxRsAmanuensis {

	private CodeDocumentationReader codeDocumentationReader;
	private DocumentationWriter documentationWriter;

	public JaxRsAmanuensis(CodeDocumentationReader codeDocumentationReader, DocumentationWriter documentationWriter) {
		this.codeDocumentationReader = codeDocumentationReader;
		this.documentationWriter = documentationWriter;
	}

	public void doIt() {
		Map<String, Object> codeDocs = codeDocumentationReader.readAll();
		documentationWriter.write(codeDocs);
	}

}
