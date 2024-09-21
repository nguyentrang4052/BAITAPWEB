package vn.iostar.services;

import vn.iostar.models.UserModel;

public interface IUserService {
	UserModel login(String username,String password);
	UserModel get(String username);
	UserModel findByUserName(String username);
	
	void insert(UserModel user);
	boolean register(String email, String username, String fullname, String password, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void changePassword(String username, String password);
}
