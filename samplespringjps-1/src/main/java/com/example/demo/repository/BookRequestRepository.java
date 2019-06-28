package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book_Request;

@Repository("bookRequestRepository")
public interface BookRequestRepository extends JpaRepository<Book_Request, Serializable>
{
	
	@Query(
			value ="SELECT * FROM book_request WHERE book_id = ?1 and user_id = ?2",
			nativeQuery = true)
	Book_Request findRecordByBookIdAndUserId(int book_id,int user_id);
}
