package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Author;
import com.app.service.AuthorService;



@RestController
@RequestMapping("/authors")
@CrossOrigin(origins="http://loclahost:3000")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	
	public AuthorController() {
		System.out.println("in def constr of"+getClass());
	}
	
	@GetMapping
	public List<Author> listAuthor(){
		System.out.println("in list authors");
		return authorService.getAllAuthors();
		}
	
	@PostMapping("/post")
	public Author saveAuthorDetails(@RequestBody Author transientAuthor){
		System.out.println("in save " + transientAuthor);
		return (authorService.addAuthorDetails(transientAuthor));
	}
	
	@DeleteMapping("/{AuthorId}")
	public String DeleteAuthorDetails(@PathVariable Long AuthorId) {
		return authorService.DeleteAuthorDetails(AuthorId);
	}
	
	
	
	
	
	

}
