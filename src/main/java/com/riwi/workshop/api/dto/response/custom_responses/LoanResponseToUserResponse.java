package com.riwi.workshop.api.dto.response.custom_responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseToUserResponse {
    private Long id;
    private LocalDateTime loan_date;
    private LocalDate return_date;
    private String status;
    private BookBasicResponse book;
}
