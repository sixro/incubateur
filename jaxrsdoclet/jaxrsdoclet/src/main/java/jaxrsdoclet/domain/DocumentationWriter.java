package jaxrsdoclet.domain;

import java.util.Map;

public interface DocumentationWriter {

	void write(Map<String, Object> codeDocumentation);

}
