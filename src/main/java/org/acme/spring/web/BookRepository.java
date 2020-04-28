package org.acme.spring.web;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {

    List<Book> findByPublicationYearIsBetween(Integer lower, Integer higher);
}
