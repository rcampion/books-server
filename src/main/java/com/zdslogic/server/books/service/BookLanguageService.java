package com.zdslogic.server.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.books.domain.BookLanguageEntity;

@Service
public interface BookLanguageService {

	public EntityManagerFactory getEntityManagerFactory();
	
	//BookLanguageEntity findBookLanguage(String name);

    Page<BookLanguageEntity> findBookLanguages(Pageable pageable);

    //Page<BookLanguageEntity> searchBookLanguages(String name);
    
	Page<BookLanguageEntity> searchBookLanguages(Pageable pageable, Specification<BookLanguageEntity> spec);

    BookLanguageEntity getBookLanguage(Integer id);
    
    BookLanguageEntity getBookLanguage(int id);    

    //Page<BookLanguageMemberEntity> findBookLanguageMembers(int id); 
    
    public BookLanguageEntity saveBookLanguage(BookLanguageEntity bookLanguage);

    public void updateBookLanguage(BookLanguageEntity bookLanguage);

	void deleteBookLanguage(int id);    
}
