package jaxrsdoclet.domain;

public class RestResourceDoc {

	private final String path;
	private final String comment;
	
	public RestResourceDoc(String path, String comment) {
		super();
		this.path = path;
		this.comment = comment;
	}

	public String getPath() {
		return path;
	}

	public String getComment() {
		return comment;
	}
	
}
