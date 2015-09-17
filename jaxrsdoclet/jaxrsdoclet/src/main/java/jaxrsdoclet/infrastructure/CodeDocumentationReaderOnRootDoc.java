package jaxrsdoclet.infrastructure;

import java.util.*;

import jaxrsdoclet.domain.CodeDocumentationReader;

import com.sun.javadoc.*;
import com.sun.javadoc.AnnotationDesc.ElementValuePair;

public class CodeDocumentationReaderOnRootDoc implements CodeDocumentationReader {

	private final RootDoc rootDoc;
	
	public CodeDocumentationReaderOnRootDoc(RootDoc rootDoc) {
		super();
		this.rootDoc = rootDoc;
	}

	@Override
	public Map<String, Object> readAll() {
		Map<String, Object> codeDocs = new LinkedHashMap<String, Object>();
		List<ClassDoc> resourcesDocs = findJaxRsResources();
		for (ClassDoc resourceDoc : resourcesDocs) {
			System.out.println(resourceDoc.name());
			System.out.println("  a. " + resourceDoc.typeName());
			System.out.println("    1. " + resourceDoc.getRawCommentText());
			System.out.println("    2. " + resourceDoc.commentText());
			System.out.println("    3. " + resourceDoc.dimension());
			System.out.println("    4. " + pathOf(resourceDoc));
		}
		codeDocs.put("", "");
		return codeDocs;
	}

	private List<ClassDoc> findJaxRsResources() {
		List<ClassDoc> resourcesDocs = new LinkedList<ClassDoc>();
		PackageDoc[] packageDocs = rootDoc.specifiedPackages();
		for (PackageDoc packageDoc : packageDocs) {
			ClassDoc[] classDocs = packageDoc.allClasses();
			for (ClassDoc classDoc : classDocs) {
				AnnotationDesc[] annotationDescs = classDoc.annotations();
				for (AnnotationDesc annotationDesc : annotationDescs) {
					AnnotationTypeDoc annotationTypeDoc = annotationDesc.annotationType();
					if ("Path".equals(annotationTypeDoc.name()))
						resourcesDocs.add(classDoc);
				}
			}
		}
		return resourcesDocs;
	}

	private String pathOf(ClassDoc classDoc) {
		AnnotationDesc[] annotationDescs = classDoc.annotations();
		for (AnnotationDesc annotationDesc : annotationDescs) {
			AnnotationTypeDoc annotationTypeDoc = annotationDesc.annotationType();
			if ("Path".equals(annotationTypeDoc.name())) {
				ElementValuePair[] elementValues = annotationDesc.elementValues();
				for (ElementValuePair elem : elementValues) {
					if ("value".equals(elem.element().name()))
						return (String) elem.value().value();
				}
			}
		}
		return null;
	}
	
}
