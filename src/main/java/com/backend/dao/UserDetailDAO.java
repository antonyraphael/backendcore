package com.backend.dao;

import java.util.List;


import com.backend.model.UserDetail;

public interface UserDetailDAO {
	public boolean registerUser(UserDetail user);
	public boolean updateAddress(UserDetail user);
	
	public UserDetail getUser(String username);
	public List<UserDetail> listUserDetails();
	
}
