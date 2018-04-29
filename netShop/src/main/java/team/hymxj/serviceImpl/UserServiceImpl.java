package team.hymxj.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hymxj.dao.UserDao;
import team.hymxj.entity.User;
import team.hymxj.service.UserSevice;
import team.hymxj.utils.MD5Util;

@Service("userService")
public class UserServiceImpl implements UserSevice {

	@Autowired
	public UserDao userDao;
	public User checkPassword(String phone, String password) {
		String md5Password=MD5Util.MD5EncodeUtf8(password);
		User loginUser=userDao.login(phone, md5Password);
		return loginUser;
	}

	public User PhoneNumberExists(String phoneNumber) {
		User user=userDao.selectUserByPhone(phoneNumber);
		if(user==null)
			return null;
		else
			return user;
	}

	public Boolean modifyInfomation(User user) {
		user.setUpdateTime(new Date());
		Boolean isOk=userDao.updateUser(user);
		return isOk;
	}

	public Boolean checkAnswer(String phone,String answer) {
		User user=userDao.selectUserByPhone(phone);
		if(user.getAnswer().trim().equals(answer.trim()))
			return true;
		else
			return false;
	}

	public Boolean updatePassword(Integer id,String password) {
		String md5Password=MD5Util.MD5EncodeUtf8(password);
		return userDao.changePassword(id,md5Password);
	}

	public Boolean insertUser(User user){
		String md5Password=MD5Util.MD5EncodeUtf8(user.getPassword());
		user.setPassword(md5Password);
		Date date=new Date();
		user.setRole(Short.valueOf("0"));
		user.setCreateTime(date);
		user.setUpdateTime(date);
		System.out.println(user);
		return userDao.insertUser(user);
	}
}
