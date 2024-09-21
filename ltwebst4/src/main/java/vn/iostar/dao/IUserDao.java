package vn.iostar.dao;

import vn.iostar.models.UserModel;

public interface IUserDao {
	
	UserModel get(String username);
	UserModel findByUserName(String username);
	
	void insert(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistPhone(String phone);
	boolean checkExistUsername(String username);
	void changePassword(String username, String password);
}
