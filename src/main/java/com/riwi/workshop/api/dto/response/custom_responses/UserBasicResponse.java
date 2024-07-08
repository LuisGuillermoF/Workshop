package com.riwi.workshop.api.dto.response.custom_responses;

import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.Reservation;
import com.riwi.workshop.utils.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private Type type;
}
