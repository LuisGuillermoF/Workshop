package com.riwi.workshop.infrastructure.services;

import com.riwi.workshop.api.dto.request.LoanRequest;
import com.riwi.workshop.api.dto.response.used_responses.LoanResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.UserEntity;
import com.riwi.workshop.domain.repositories.BookRepository;
import com.riwi.workshop.domain.repositories.LoanRepository;
import com.riwi.workshop.infrastructure.abstract_services.ILoanService;
import com.riwi.workshop.mappers.LoanMapper;
import com.riwi.workshop.util.enums.SortType;
import com.riwi.workshop.util.enums.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class LoanService  implements ILoanService {

    @Autowired
    private final LoanMapper loanMapper;

    @Autowired
    private final LoanRepository loanRepository;




    @Override
    public LoanResponse create(LoanRequest request) {
        Loan loan = this.loanMapper.requestToEntity(request);
        loan.setLoan_date(LocalDateTime.now());
        return  this.loanMapper.entityToResponse(this.loanRepository.save(loan));
    }

    @Override
    public LoanResponse get(Long id) {
        return this.loanMapper.entityToResponse(this.findById(id));
    }

    @Override
    public LoanResponse update(LoanRequest request, Long id) {
        Loan loan = this.findById(id);
        Loan updatedLoan = this.loanMapper.requestToEntity(request);
        updatedLoan.setId(loan.getId());
        updatedLoan.setLoan_date(loan.getLoan_date());
        return this.loanMapper.entityToResponse(this.loanRepository.save(updatedLoan));
    }

    @Override
    public void delete(Long id) {
        Loan loan = this.findById(id);
        this.loanRepository.delete(loan);
    }

    @Override
    public Page<LoanResponse> getAll(int page, int size, SortType sort) {
        if (page < 0){
            page = 0;
        };

        PageRequest pageRequest =  null;

        switch (sort){
            case NONE -> pageRequest = PageRequest.of(page, size);
            case ASC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.loanRepository.findAll(pageRequest).map(this.loanMapper::entityToResponse);
    }


    private Loan findById(Long id){
        return this.loanRepository.findById(id).orElseThrow(() -> new BadRequestException("Loan could not be found"));
    }
}
