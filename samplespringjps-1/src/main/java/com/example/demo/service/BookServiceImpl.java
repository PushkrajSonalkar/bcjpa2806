package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Book_Request;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BookRequestRepository;

@Service("bookService")
public class BookServiceImpl implements BookService
{


	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookRequestRepository bookRequestRepository;

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Optional<Book> getBook(Integer Id) {
		 return bookRepository.findById(Id);
	}
	
	@Override
	public Book updateBook(Integer id,Book book) {
		return bookRepository.save(book);
	}
	
	@Override
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books=new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}


	@Override
	public void addBookRequest(Book_Request book_Request) {
		bookRequestRepository.save(book_Request);
	}

	@Override
	public Book findById(int bid) {
		return bookRepository.findById(bid).get();
	}

	@Override
	public Book getOne(int id) {
		// TODO Auto-generated method stub
		return bookRepository.getOne(id);
	}


	
	
}
