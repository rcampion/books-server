package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {
	 
    Optional<BookEntity> findByBookId(Integer id);
	
    Page<BookEntity> findByTitleLike(Pageable pageable, String description);
	 
	BookEntity findByTitle(String name);
	
}
