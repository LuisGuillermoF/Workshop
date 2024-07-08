package com.riwi.workshop.mappers;


/*Por qué es una interfaz
* Es correcto hacer una inyeccion de dependencias usando metodos de una interfaz?
*
* */


import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.request.UserRequest;
import com.riwi.workshop.api.dto.response.used_responses.BookResponse;
import com.riwi.workshop.api.dto.response.used_responses.UserResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    BookResponse entityToResponse(Book book);
    Book requestToEntity(BookRequest userRequest);
}
