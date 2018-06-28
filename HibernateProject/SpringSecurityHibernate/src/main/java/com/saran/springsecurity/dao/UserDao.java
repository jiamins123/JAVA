package com.saran.springsecurity.dao;

import com.saran.springsecurity.model.User;

public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
}

