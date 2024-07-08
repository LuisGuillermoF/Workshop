package com.riwi.workshop.infrastructure.abstract_services;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.request.LoanRequest;
import com.riwi.workshop.api.dto.response.used_responses.BookResponse;
import com.riwi.workshop.api.dto.response.used_responses.LoanResponse;

public interface ILoanService extends CrudService<LoanRequest, LoanResponse, Long>{
    public String FIELD_BY_SORT = "id";
}
