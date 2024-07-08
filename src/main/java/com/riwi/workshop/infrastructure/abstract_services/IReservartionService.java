package com.riwi.workshop.infrastructure.abstract_services;

import com.riwi.workshop.api.dto.request.LoanRequest;
import com.riwi.workshop.api.dto.request.ReservationRequest;
import com.riwi.workshop.api.dto.response.used_responses.LoanResponse;
import com.riwi.workshop.api.dto.response.used_responses.ReservationResponse;

public interface IReservartionService extends CrudService<ReservationRequest, ReservationResponse, Long>{
}
