package jaxrsdoclet.domain;

import java.util.*;

public class CodeDocumentation {

	private final String overview;
	private final List<RestResourceDoc> restResourceDocs;
	
	public CodeDocumentation(String overview) {
		super();
		this.overview = overview;
		
		this.restResourceDocs = new LinkedList<RestResourceDoc>();
	}

	public String getOverview() {
		return overview;
	}

	public List<RestResourceDoc> getRestResourceDocs() {
		return Collections.unmodifiableList(restResourceDocs);
	}

	public void add(RestResourceDoc restResourceDoc) {
		restResourceDocs.add(restResourceDoc);
	}
	
}
