package team.hymxj.service;


import team.hymxj.entity.User;

public interface UserSevice {
	public User checkPassword(String phone,String password);
	public User PhoneNumberExists(String phoneNumber);
	public Boolean modifyInfomation(User user);
	public Boolean checkAnswer(String phone,String answer);
	public Boolean updatePassword(Integer id,String password);
	public Boolean insertUser(User user);
}
