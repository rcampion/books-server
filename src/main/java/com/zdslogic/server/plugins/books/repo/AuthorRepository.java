package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.AuthorEntity;

@Repository
@Qualifier("authorRepository")
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>, JpaSpecificationExecutor<AuthorEntity> {
	 
    Optional<AuthorEntity> findByAuthorId(Integer id);
	
    //Page<AuthorEntity> findByTitleLike(Pageable pageable, String description);
	 
	//AuthorEntity findByTitle(String name);
	
	//AuthorEntity findByAuthor(String key);
	
}
