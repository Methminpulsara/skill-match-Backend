package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserDto;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UesrServiceImpl implements UserService {

    final UserDto dto;
    final ModelMapper mapper;

    @Override
    public User add(User user) {

        Optional<UserEntity> existingUser = dto.findByEmail(user.getEmail());
        if (existingUser.isPresent()){
            throw new RuntimeException("User already exists");
        }
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity = dto.save(userEntity);
        return mapper.map(userEntity, User.class);
    }

    @Override
    public void delete(Long id) {
        dto.deleteById(id);
    }

    @Override
    public void update(User user) {
        dto.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public User search(String email, String password) {
        UserEntity entity = dto.findByEmailAndPassword(email,password);
            if(email==null){
                return null;
             }
                return mapper.map(entity, User.class);
             }
    }