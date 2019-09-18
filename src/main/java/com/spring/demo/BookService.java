package com.spring.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.demo.Book;
import com.spring.demo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	/**
	 * 查詢所有書單列表
	 * @return
	 */ 
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	/**
	 * 新增一個清單,更新也是用這個 
	 * @param book
	 * @return
	 */
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	/**
	 * 查詢一筆書單
	 * @param id
	 * @return
	 */	
	public Book findOne(long id) {
		return bookRepository.findById(id);
	}
	

	/**
	 * 刪除
	 * @param id
	 * @return
	 */	
	public void deleteOne(long id) {
		bookRepository.deleteById(id);
	}
	
	/**
	 * 根據interface自定義方法查詢
	 * @param author
	 * @return List<Book
	 */	
	public List<Book> findByAuthor(String author){
		return bookRepository.findByAuthor(author);
	}
	
	/**
	 * 根據interface自定義方法查詢
	 * @param author,status
	 * @return List<Book>
	 */	
	public List<Book> findByAuthorAndStatus(String author,int status){
		return bookRepository.findByAuthorAndStatus(author, status);
	}
	
	public List<Book> findByDescriptionEndsWith(String description){
		return bookRepository.findByDescriptionEndsWith(description);
	}

	public List<Book> findByDescriptionContains(String description){
		return bookRepository.findByDescriptionContains(description);
	}
	
	/**
	 *自定義查詢
	 * @param len
	 * @return List<Book>
	 **/
	public List<Book> findByJPQL(int len){
		return bookRepository.findByJPQL(len);
	}
	
	/**
	 *自定義更新
	 * @param status,id
	 * @return int
	 **/
	@Transactional //納入事務管理,要馬都成功,要馬都失敗
	public int updateByJPQL(int status,long id) {
		return bookRepository.updateByJPQL(status, id);
	}
	
	/**
	 *自定義刪除
	 * @param status,id
	 * @return int
	 **/
	@Transactional //納入事務管理,要馬都成功,要馬都失敗
	public int daleteByJPQL(long id) {
		return bookRepository.daleteByJPQL(id);
	}	
	
}
