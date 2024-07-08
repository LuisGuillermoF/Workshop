package com.riwi.workshop.infrastructure.services;


import com.riwi.workshop.api.dto.request.BookRequest;
import com.riwi.workshop.api.dto.request.UserRequest;
import com.riwi.workshop.api.dto.response.used_responses.BookResponse;
import com.riwi.workshop.api.dto.response.used_responses.UserResponse;
import com.riwi.workshop.domain.entities.Book;
import com.riwi.workshop.domain.entities.UserEntity;
import com.riwi.workshop.domain.repositories.UserRepository;
import com.riwi.workshop.infrastructure.abstract_services.IUserService;
import com.riwi.workshop.mappers.UserMapper;
import com.riwi.workshop.util.enums.exceptions.BadRequestException;
import com.riwi.workshop.utils.SortType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    /*Repositorio*/
    @Autowired
    private final UserRepository userRepository;
    /*Mapper*/
    @Autowired
    private final UserMapper userMapper;


    @Override
    public UserResponse create(UserRequest request) {
        /*Verificadp*/
        UserEntity userEntity = this.userMapper.requestToEntity(request);
        return this.userMapper.entityToResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserResponse get(Long id) {
        UserEntity user = this.findById(id);
        return this.userMapper.entityToResponse(user);
    }
    @Override
    public UserResponse update(UserRequest request, Long id) {
        UserEntity user = this.findById(id);
        UserEntity userEntity = this.userMapper.requestToEntity(request);
        userEntity.setId(user.getId());
        userEntity.setLoans(user.getLoans());
        userEntity.setRerservations(user.getRerservations());
        return this.userMapper.entityToResponse(this.userRepository.save(userEntity));
    }
    @Override
    public void delete(Long id) {
        UserEntity user = this.findById(id);
        this.userRepository.delete(user);
    }
    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sort) {
        if (page < 0){
            page = 0;
        };

        PageRequest pageRequest =  null;

        switch (sort){
            case NONE -> pageRequest = PageRequest.of(page, size);
            case ASC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.userRepository.findAll(pageRequest).map(this.userMapper::entityToResponse);
    }
    private UserEntity findById(Long id){
        return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException("User could not be found"));
    }
}
