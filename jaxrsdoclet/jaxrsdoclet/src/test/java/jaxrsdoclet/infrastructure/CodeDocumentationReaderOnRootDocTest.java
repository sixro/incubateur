package jaxrsdoclet.infrastructure;

import static org.junit.Assert.*;

import java.util.Map;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import com.sun.javadoc.*;

public class CodeDocumentationReaderOnRootDocTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private RootDoc rootDoc = context.mock(RootDoc.class);
	private CodeDocumentationReaderOnRootDoc reader = new CodeDocumentationReaderOnRootDoc(rootDoc);
	
	@Test
	@Ignore
	public void returns_code_docs() {
		final PackageDoc aPackageDoc = context.mock(PackageDoc.class);
		
		context.checking(new Expectations() {{ 
			oneOf(rootDoc).specifiedPackages();
				will(returnValue(new PackageDoc[]{ aPackageDoc }));
		}});
		
		
		Map<String, Object> codeDocs = reader.readAll();
		assertFalse(codeDocs.isEmpty());
	}

}
