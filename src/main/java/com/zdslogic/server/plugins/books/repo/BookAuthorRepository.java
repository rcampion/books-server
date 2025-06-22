package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.BookAuthorEntity;

@Repository
@Qualifier("bookAuthorRepository")
public interface BookAuthorRepository extends JpaRepository<BookAuthorEntity, Integer>, JpaSpecificationExecutor<BookAuthorEntity> {
	 
    Optional<BookAuthorEntity> findByBookId(Integer id);
	
    //Page<AuthorEntity> findByTitleLike(Pageable pageable, String description);
	 
	//AuthorEntity findByTitle(String name);
	
	//AuthorEntity findByAuthor(String key);
	
}
