package com.riwi.workshop.domain.repositories;

import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
