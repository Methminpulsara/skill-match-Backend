package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserDto;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UesrServiceImpl implements UserService {

    final UserDto dto;
    final ModelMapper mapper;

    @Override
    public User add(User user) {
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
        return mapper.map(dto.findByEmailAndPassword(email,password),User.class);
    }
}
