package com.riwi.workshop.infrastructure.abstract_services;

import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.request.UserRequest;
import com.riwi.workshop.api.dto.response.used_responses.BookResponse;
import com.riwi.workshop.api.dto.response.used_responses.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, Long>{
    public String FIELD_BY_SORT = "username";
}
