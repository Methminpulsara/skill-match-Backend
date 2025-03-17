package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UesrServiceImpl implements UserService {

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User search(String userName, String password) {
        return null;
    }
}
