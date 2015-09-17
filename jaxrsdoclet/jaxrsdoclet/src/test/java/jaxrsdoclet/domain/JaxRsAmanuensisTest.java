package jaxrsdoclet.domain;

import static org.junit.Assert.*;

import java.util.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

public class JaxRsAmanuensisTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private CodeDocumentationReader codeDocumentationReader = context.mock(CodeDocumentationReader.class);
	private DocumentationWriter documentationWriter = context.mock(DocumentationWriter.class);
	private JaxRsAmanuensis amanuensis = new JaxRsAmanuensis(codeDocumentationReader, documentationWriter);
	
	@Test
	public void read_doc_and_then_write() {
		final CodeDocumentation aCodeDocumentation = new CodeDocumentation("my overview");		
		context.checking(new Expectations() {{ 
			oneOf(codeDocumentationReader).readAll();
				will(returnValue(aCodeDocumentation));
			oneOf(documentationWriter).write(aCodeDocumentation);
		}});
		
		amanuensis.doIt();
	}

}
