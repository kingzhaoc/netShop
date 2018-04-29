package team.hymxj.dao;

import org.apache.ibatis.annotations.Param;

import team.hymxj.entity.User;

public interface UserDao {
	public User selectUserByPhone(String phone);
	public User login(@Param("phone")String phone,@Param("password")String password);
	public Boolean updateUser(User user);
	public Boolean changePassword(@Param("id")Integer id,@Param("newPassword")String newPassword);
	public Boolean insertUser(User user);
}
