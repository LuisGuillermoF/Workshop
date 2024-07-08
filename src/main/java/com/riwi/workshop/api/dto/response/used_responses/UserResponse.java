package com.riwi.workshop.api.dto.response.used_responses;

import com.riwi.workshop.api.dto.response.custom_responses.LoanResponseToUserResponse;
import com.riwi.workshop.api.dto.response.custom_responses.ReservationResponseToUserResponse;
import com.riwi.workshop.utils.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class    UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private Type type;
    private List<ReservationResponseToUserResponse> rerservations;
    private List<LoanResponseToUserResponse> loans;
}
