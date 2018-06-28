package com.jimmy.service;

import com.jimmy.model.User;

public interface UserService {

    User findById(int id);
    
    User findBySso(String sso);
    
}