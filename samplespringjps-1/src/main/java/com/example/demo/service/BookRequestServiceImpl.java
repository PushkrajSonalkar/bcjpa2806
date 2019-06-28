package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Book_Request;
import com.example.demo.repository.BookRequestRepository;


@Service("bookRequestService")
public class BookRequestServiceImpl implements BookRequestService
{
	@Autowired
	private BookRequestRepository bookRequestRepository;
	@Override
	public Book_Request saveRequest(Book_Request book_request) 
	{
//		book_request.setBook_id(book_request.getBook_id());
//		book_request.setUser_id(book_request.getUser_id());
		return bookRequestRepository.save(book_request);
	}
	@Override
	public Book_Request getByUserId(int uid) 
	{
		return bookRequestRepository.findById(uid).get();
	}
	@Override
	public Book_Request findRecordByBookIdAndUserId(int i, int k) {
		return bookRequestRepository.findRecordByBookIdAndUserId(i, k);
	}

}
