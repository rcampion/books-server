package com.rkc.zds.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkc.zds.books.dto.BookDTO;

public interface BookRepository extends JpaRepository<BookDTO, Integer> {

    Optional<BookDTO> findById(String id);

}
