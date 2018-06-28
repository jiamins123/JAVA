package com.saran.springsecurity.service;

import com.saran.springsecurity.model.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}