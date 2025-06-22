package com.zdslogic.server.plugins.books.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zdslogic.server.plugins.books.domain.CustomerEntity;

@Repository
@Qualifier("customerRepository")
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>, JpaSpecificationExecutor<CustomerEntity> {

    Optional<CustomerEntity> findByCustomerId(Integer id);

}
