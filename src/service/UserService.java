package service;

import Dao.NewsUserDao;
import entity.Newsusers;

public class UserService {
	NewsUserDao dao = new NewsUserDao();

	public Newsusers dologin(String name, String passwrod) {
		Newsusers user = dao.findByName(name);
		if (user != null && user.getUpwd().equals(passwrod)) {
			return user;
		} else {
			return null;
		}

	}
}
