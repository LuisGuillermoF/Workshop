package com.riwi.workshop.infrastructure.abstract_services;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.response.used_responses.BookResponse;

public interface IBookService extends CrudService<BookRequest, BookResponse, Long>{
    public String FIELD_BY_SORT = "title";
}
