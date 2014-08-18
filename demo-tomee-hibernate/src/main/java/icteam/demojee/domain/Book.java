/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package icteam.demojee.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Represents a book.
 */
@Entity
public class Book {

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Size(min = 3)
	private String title;

	/**
	 * @deprecated Needed by Hibernate
	 */
	protected Book() {
		super();
		this.id = null;
		this.title = null;
	}

	/**
	 * Create a book with specified title.
	 * 
	 * @param title a title
	 */
	public Book(String title) {
		super();
		this.id = null;

		this.title = title;
	}

	/**
	 * Returns the id of this book.
	 * 
	 * @return id of this book
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Returns the title of this book.
	 * 
	 * @return title of this book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of this book to the specified one.
	 * 
	 * @param title new title of this book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;

		Book that = (Book) obj;
		return getTitle().equalsIgnoreCase(that.getTitle());
	}

	@Override
	public int hashCode() {
		return getTitle().hashCode();
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

}
