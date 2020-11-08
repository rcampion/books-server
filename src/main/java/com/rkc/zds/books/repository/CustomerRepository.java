package com.rkc.zds.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkc.zds.books.dto.CustomerDTO;

public interface CustomerRepository extends JpaRepository<CustomerDTO, Integer> {

    Optional<CustomerDTO> findById(String id);

}
