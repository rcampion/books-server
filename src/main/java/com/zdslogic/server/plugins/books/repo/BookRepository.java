package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.BookEntity;

@Repository
@Qualifier("bookRepository")
public interface BookRepository extends JpaRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {
	 
    Optional<BookEntity> findByBookId(Integer id);
	
    Page<BookEntity> findByTitleLike(Pageable pageable, String description);
	 
	BookEntity findByTitle(String name);
	
}
