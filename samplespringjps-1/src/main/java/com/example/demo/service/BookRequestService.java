package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book_Request;

public interface BookRequestService 
{
	public Book_Request saveRequest(Book_Request b);

	public Book_Request getByUserId(int uid);
	public Book_Request findRecordByBookIdAndUserId(int i,int k);
}
