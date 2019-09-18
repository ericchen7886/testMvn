package com.spring.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	//這邊都是Overwried interface
	//自定義method,  查詢條件: findBy + 字串, 會自動mapping查詢語句
	List<Book> findByAuthor(String author);
	
	//自定義method,  查詢條件: findBy + 字串, 會自動mapping查詢語句
	Book findById(long id);
		
	//自定義method
	List<Book> findByAuthorAndStatus(String author,int status);
		
	//自定義method,findBy:查找 , EndsWith以什麼開始或結束 查詢包含的desc
	List<Book> findByDescriptionEndsWith(String desc);
	
	//自定義method,包含什麼
	//Select * FROM book.book where description like '%a33'
	List<Book> findByDescriptionContains(String desc);
		
	//Select * FROM book.book where LENGTH('name')>3
	@Query(value = "select * from book.book where length(name) > ?1" , nativeQuery = true)
//	@Query("select b from Book b where length(b.name) > ?1") 寫法相同意思,數字代表傳入的
	List<Book> findByJPQL(int len);
	
	@Transactional
	//標示可以執行的操作
	@Modifying
	//自定義Book為Bean名稱
	@Query("update Book b set b.status = ?1 where id=?2")
	int updateByJPQL(int status,long id);
	
	@Transactional
	@Modifying
	@Query("delete from Book b where b.id= ?1")
	int daleteByJPQL(long id);
}
