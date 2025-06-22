package com.zdslogic.server.plugins.books.service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zdslogic.server.plugins.books.domain.PublisherEntity;

@Service
public interface PublisherService {

	public EntityManagerFactory getEntityManagerFactory();
	
	//PublisherEntity findPublisher(String name);

    Page<PublisherEntity> findPublishers(Pageable pageable);

    //Page<PublisherEntity> searchPublishers(String name);
    
	Page<PublisherEntity> searchPublishers(Pageable pageable, Specification<PublisherEntity> spec);

    PublisherEntity getPublisher(int id);    

    PublisherEntity getPublisher(Integer id);
        
    //Page<PublisherMemberEntity> findPublisherMembers(int id); 
    
    public PublisherEntity savePublisher(PublisherEntity publisher);

    public void updatePublisher(PublisherEntity publisher);

	void deletePublisher(int id);    
}
