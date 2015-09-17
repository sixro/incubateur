package jaxrsdoclet.infrastructure;

import java.util.*;

import com.sun.javadoc.*;

import jaxrsdoclet.domain.CodeDocumentationReader;

public class CodeDocumentationReaderOnRootDoc implements CodeDocumentationReader {

	private final RootDoc rootDoc;
	
	public CodeDocumentationReaderOnRootDoc(RootDoc rootDoc) {
		super();
		this.rootDoc = rootDoc;
	}

	@Override
	public Map<String, Object> readAll() {
		Map<String, Object> codeDocs = new LinkedHashMap<String, Object>();
		PackageDoc[] packageDocs = rootDoc.specifiedPackages();
		for (PackageDoc packageDoc : packageDocs) {
			System.out.println("Package: " + packageDoc.name());

			ClassDoc[] classDocs = packageDoc.allClasses();
			for (ClassDoc classDoc : classDocs) {
				System.out.println("  Class: " + classDoc.name());
				AnnotationDesc[] annotationDescs = classDoc.annotations();
				for (AnnotationDesc annotationDesc : annotationDescs) {
					AnnotationTypeDoc annotationTypeDoc = annotationDesc.annotationType();
					System.out.println("    @" + annotationTypeDoc.name());
				}
			}
		}
		
		codeDocs.put("", "");
		return codeDocs;
	}

}
