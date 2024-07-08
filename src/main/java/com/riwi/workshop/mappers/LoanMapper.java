package com.riwi.workshop.mappers;


import com.riwi.workshop.api.dto.request.LoanRequest;
import com.riwi.workshop.api.dto.response.used_responses.LoanResponse;
import com.riwi.workshop.domain.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {
    //EntityToReponse
    Loan requestToEntity (LoanRequest loanRequest);

    LoanResponse entityToResponse (Loan loan);
}
