package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;
import com.example.demo.model.*;

@RestController
@RequestMapping("/books")
public class BookRestController {

    public static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	
	@Autowired
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list_books" , method = RequestMethod.GET, headers="Accept= application/json")
	public@ResponseBody ResponseEntity<Object> getListBooks() {
		
		List<Book> listBook=bookService.getAllBooks();
		
		List<JSONObject> books = new ArrayList<JSONObject>();
		
	    for (Book b: listBook) {
	        JSONObject book = new JSONObject();
	        book.put("id", b.getId());
	        book.put("book_name", b.getName());
	        book.put("authername", b.getAuthername());
	        book.put("publicationname", b.getPublicationname());
	        book.put("price", b.getPrice());
	        book.put("stock",b.getStock());
	        
	        books.add(book);
	    }
		return new ResponseEntity<Object>(books,HttpStatus.OK);
		

	}
	
	@RequestMapping(value="/add_books" , method = RequestMethod.POST, headers="Accept= application/json")
	public ResponseEntity<Book> addBooks(@RequestBody Book book){
		
		bookService.addBook(book);
		HttpHeaders header=new HttpHeaders();
		
		return new ResponseEntity<Book>(header,HttpStatus.CREATED);

	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/req_book" , method = RequestMethod.GET, headers="Accept= application/json")
	public@ResponseBody ResponseEntity<Object> getReqListBooks() {
		
		List<Book> listBook=bookService.getAllBooks();
		
		List<JSONObject> books = new ArrayList<JSONObject>();
		
	    for (Book b: listBook) {
	        JSONObject book = new JSONObject();
	        book.put("id", b.getId());
	        book.put("book_name", b.getName());
	        book.put("authername", b.getAuthername());
	        book.put("publicationname", b.getPublicationname());
	        book.put("price", b.getPrice());
	        book.put("stock",b.getStock());
	        
	        books.add(book);
	    }
		return new ResponseEntity<Object>(books,HttpStatus.OK);
		

	}

}
