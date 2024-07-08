package com.riwi.workshop.api.dto.response.custom_responses;

import com.riwi.workshop.domain.entities.Loan;
import com.riwi.workshop.domain.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBasicResponse {
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;
    private String isbn;
}
