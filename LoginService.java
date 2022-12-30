package com.training.web.service;

import java.util.List;

import com.training.web.model.User;

public interface LoginService {
	boolean isValidUser(String prodName, String proddesc);
	List<User> getUsers();
}
