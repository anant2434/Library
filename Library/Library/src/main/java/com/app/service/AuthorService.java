package com.app.service;

import java.util.List;

import com.app.entities.Author;

public interface AuthorService {
List<Author> getAllAuthors();
Author addAuthorDetails(Author TransientAuthor);

String DeleteAuthorDetails(Long AuthorId);

Author getAuthorDetails(Long AuthorId);

Author updateAuthorDetails(Author detachedAuthor);


}
