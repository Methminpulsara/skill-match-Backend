package edu.icet.ecom.service;

import edu.icet.ecom.dto.User;

public interface UserService {

    User add (User user);
    void delete(Long id);
    void update(User user);
    User search(String email , String password);




}
