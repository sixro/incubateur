package example;

public class Product {

	private final Object id;
	private final String description;
	private final Category category;

	public Product(Object id, String description, Category category) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
	}

	public Object getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description
				+ ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category != other.category)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
