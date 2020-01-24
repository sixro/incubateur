package burgeonapp;

import java.util.*;

import org.apache.commons.lang3.builder.*;

public class PageData {

	private final List<Map<String, Object>> data;
	private final Map<String, Object> meta;
	
	public PageData(List<Map<String, Object>> data) {
		super();
		this.data = data;
		this.meta = new LinkedHashMap<>();
	}

	
	public List<Map<String, Object>> getData() {
		return Collections.unmodifiableList(data);
	}

	public void addMeta(String metaname, Object value) {
		meta.put(metaname, value);
	}
	
	public Map<String, Object> getMeta() {
		return Collections.unmodifiableMap(meta);
	}

	public Object getMeta(String metaname) {
		return meta.get(metaname);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
