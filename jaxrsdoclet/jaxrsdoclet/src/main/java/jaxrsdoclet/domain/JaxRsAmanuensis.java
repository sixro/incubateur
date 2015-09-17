package jaxrsdoclet.domain;


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
		CodeDocumentation codeDoc = codeDocumentationReader.readAll();
		documentationWriter.write(codeDoc);
	}

}
