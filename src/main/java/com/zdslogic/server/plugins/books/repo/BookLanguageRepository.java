package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.BookLanguageEntity;

@Repository
@Qualifier("bookLanguageRepository")
public interface BookLanguageRepository extends JpaRepository<BookLanguageEntity, Integer>, JpaSpecificationExecutor<BookLanguageEntity> {
	 
    Optional<BookLanguageEntity> findByLanguageId(Integer id);
	
    //Page<BookLanguageEntity> findByTitleLike(Pageable pageable, String description);
	 
	//BookLanguageEntity findByTitle(String name);
	
	//BookLanguageEntity findByBookLanguage(String key);
	
}
