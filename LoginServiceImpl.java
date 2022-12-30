package com.training.web.service;

import java.util.List;
import com.training.web.dao.LoginDao;
import com.training.web.dao.LoginDaoImpl;
import com.training.web.model.User;
public class LoginServiceImpl implements LoginService{

	
		LoginDao dao = new LoginDaoImpl();
		@Override
		public boolean isValidUser(String prodName, String proddesc) {
			
			boolean isValid = false;
			List<User> userList = dao.getUsers();
			for (User user : userList) {
				if (user.getProdName().equals(prodName) && user.getProddesc().equals(proddesc)) {
					isValid = true;
				}
			}
			return isValid;
		}

		@Override
		public List<User> getUsers() {
			List<User> userList = dao.getUsers();
			return userList;
		}
	}


