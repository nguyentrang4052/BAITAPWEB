package vn.iostar.services.impl;

import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoimpl;

public class UserServiceimpl implements IUserService {
	IUserDao userDao = new UserDaoimpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String username, String fullname, String password, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, phone, date, 1));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void changePassword(String username, String password) {
		userDao.changePassword(username, password);
	}

	@Override
	public void updateProfile(String fullname, String phone, String images, String username) {
		userDao.updateProfile(fullname, phone, images, username);
	}
}
