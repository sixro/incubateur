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
package icteam.demojee.infrastructure.domain;

import icteam.demojee.domain.*;

import java.util.List;

import javax.ejb.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Represents an implementation of {@link BookRepository} using <a
 * href="http://en.wikipedia.org/wiki/Java_Persistence_API" target="_top" >JPA</a>.
 */
@Stateless
public class BookRepositoryJpa implements BookRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void addBook(Book book) {
		entityManager.persist(book);
	}

	public List<Book> getAllBooks() {
		CriteriaQuery<Book> cq = entityManager.getCriteriaBuilder().createQuery(Book.class);
		cq.select(cq.from(Book.class));
		return entityManager.createQuery(cq).getResultList();
	}
	
}
