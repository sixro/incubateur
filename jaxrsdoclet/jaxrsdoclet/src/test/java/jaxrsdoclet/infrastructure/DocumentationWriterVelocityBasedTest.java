package jaxrsdoclet.infrastructure;

import static org.junit.Assert.*;

import java.io.*;

import jaxrsdoclet.domain.CodeDocumentation;

import org.apache.commons.io.*;
import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

public class DocumentationWriterVelocityBasedTest {

	@Test
	public void contains_overview() throws IOException {
		String overview = "Hello World!";
		CodeDocumentation codeDoc = new CodeDocumentation(overview);
		
		DocumentationWriterVelocityBased documentationWriter = new DocumentationWriterVelocityBased(SystemUtils.JAVA_IO_TMPDIR, null);
		documentationWriter.write(codeDoc);
		
		File apidoc = new File(SystemUtils.JAVA_IO_TMPDIR, "index.html");
		String apidocContent = FileUtils.readFileToString(apidoc);
		System.out.println(apidocContent);
		assertTrue(apidocContent.contains(overview));
	}

}
