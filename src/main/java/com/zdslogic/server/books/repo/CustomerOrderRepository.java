package com.zdslogic.server.books.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zdslogic.server.books.domain.BookEntity;
import com.zdslogic.server.books.domain.CustomerOrderEntity;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Integer>, JpaSpecificationExecutor<CustomerOrderEntity> {

    Optional<CustomerOrderEntity> findByOrderId(Integer id);

}
