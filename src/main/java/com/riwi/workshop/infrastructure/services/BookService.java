package com.riwi.workshop.infrastructure.services;


import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.request.UserRequest;
import com.riwi.workshop.api.dto.response.used_responses.BookResponse;
import com.riwi.workshop.api.dto.response.used_responses.UserResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.UserEntity;
import com.riwi.workshop.domain.repositories.BookRepository;
import com.riwi.workshop.domain.repositories.UserRepository;
import com.riwi.workshop.infrastructure.abstract_services.IBookService;
import com.riwi.workshop.infrastructure.abstract_services.IUserService;
import com.riwi.workshop.mappers.BookMapper;
import com.riwi.workshop.mappers.UserMapper;
import com.riwi.workshop.util.enums.SortType;
import com.riwi.workshop.util.enums.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    /*Repositorio*/
    @Autowired
    private final BookRepository bookRepository;
    /*Mapper*/
    @Autowired
    private final BookMapper bookMapper;


    @Override
    public BookResponse create(BookRequest request) {
        /*Verificadp*/
        Book book = this.bookMapper.requestToEntity(request);
        return this.bookMapper.entityToResponse(this.bookRepository.save(book));
    }

    @Override
    public BookResponse get(Long id) {
        Book book = this.findById(id);
        return this.bookMapper.entityToResponse(book);
    }
    @Override
    public BookResponse update(BookRequest request, Long id) {
        Book book = this.findById(id);
        Book updatedBook = this.bookMapper.requestToEntity(request);
        updatedBook.setId(book.getId());
        updatedBook.setLoans(book.getLoans());
        updatedBook.setRerservations(book.getRerservations());
        return this.bookMapper.entityToResponse(this.bookRepository.save(updatedBook));
    }
    @Override
    public void delete(Long id) {
        Book book = this.findById(id);
        this.bookRepository.delete(book);
    }
    @Override
    public Page<BookResponse> getAll(int page, int size, SortType sort) {
        if (page < 0){
            page = 0;
        };

        PageRequest pageRequest =  null;

        switch (sort){
            case NONE -> pageRequest = PageRequest.of(page, size);
            case ASC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.bookRepository.findAll(pageRequest).map(this.bookMapper::entityToResponse);
    }
    private Book findById(Long id){
        return this.bookRepository.findById(id).orElseThrow(() -> new BadRequestException("Book could not be found"));
    }
}
