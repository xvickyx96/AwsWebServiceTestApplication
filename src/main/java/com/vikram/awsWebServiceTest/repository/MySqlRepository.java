package com.vikram.awsWebServiceTest.repository;

import com.vikram.awsWebServiceTest.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlRepository extends JpaRepository<Book, Long> {
}
