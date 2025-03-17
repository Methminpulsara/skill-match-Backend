package edu.icet.ecom.service;

import edu.icet.ecom.dto.User;

public interface UserService {

    void add (User user);
    void delete(Long id);
    void update(User user);
    User search(String userName , String password);




}
