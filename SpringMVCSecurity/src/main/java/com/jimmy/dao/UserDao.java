package com.jimmy.dao;

import com.jimmy.model.User;

public interface UserDao {

    User findById(int id);
    
    User findBySSO(String sso);
    
}