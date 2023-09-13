package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entities.Author;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository AuthorRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Author> getAllAuthors(){
		return AuthorRepo.findAll();
		}
	
	public Author addAuthorDetails(Author transientAuthor) {
		return AuthorRepo.save(transientAuthor);
	}
	
	@Override
	public String DeleteAuthorDetails(Long AuthorId) {
		String mesg = "Author id invalid , can't delete author details ";
		if (AuthorRepo.existsById(AuthorId)) {
			AuthorRepo.deleteById(AuthorId);
			mesg = "Author with ID=" + AuthorId + "  deleted !";
		}
		return mesg;
	}
	
	@Override
	public Author getAuthorDetails(Long AuthorId) {
		// TODO Auto-generated method stub
		return AuthorRepo.findById(AuthorId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID , Can't get emp details!!!!"));
	}
	
	

	@Override
	public Author updateAuthorDetails(Author detachedAuthor) {
		// H.W : check if emp exists by id
		return AuthorRepo.save(detachedAuthor);
	}
	
	
	
}
