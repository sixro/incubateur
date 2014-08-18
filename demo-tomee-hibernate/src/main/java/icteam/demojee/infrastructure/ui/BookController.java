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
package icteam.demojee.infrastructure.ui;

import icteam.demojee.domain.*;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Represents a <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller" target="_top" >CONTROLLER</a> in use by pages related to books.
 */
@Stateful
@Model
public class BookController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookRepository bookRepository;

	private List<Book> booksAvailable;
	private String bookTitle;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<Book> getBooksAvailable() {
		return booksAvailable;
	}

	public void setBooksAvailable(List<Book> booksAvailable) {
		this.booksAvailable = booksAvailable;
	}

	public String fetchBooks() {
		booksAvailable = bookRepository.getAllBooks();
		
		return "success";
	}

	public String add() {
		Book book = new Book(bookTitle);
		bookRepository.addBook(book);
		
		return "success";
	}
	
}
