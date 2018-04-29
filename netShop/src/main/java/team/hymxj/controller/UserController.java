package team.hymxj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.hymxj.entity.User;
import team.hymxj.service.UserSevice;

@Controller
public class UserController {
	
	@Autowired
	 public UserSevice userService;
	
	 /**
     * 判断密码是否正确。
     * @param phone
     * @param password
     * @return 跳转主页或本页
     */
	@RequestMapping("checkPassword.do")
	
	public String checkPassword(HttpServletRequest request,@RequestParam(value="phone")String phone,@RequestParam(value="password")String password){
		User user=userService.checkPassword(phone,password);
		if(user==null){
			request.setAttribute("loginFail","登录失败，密码错误");
			request.setAttribute("phone",phone);
			return "user/login.jsp";
		}else{
			request.getSession().setAttribute("loginUser",user);
			return "index.jsp";
		}
	}	
	
	 /**
     * 判断电话号码是否已被注册。
     * @param phoneNumber
     * @return 提示信息
     */
	@RequestMapping(value="phoneNumberExists.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String PhoneNumberExists(HttpSession session,@RequestParam(value="phone")String phone){
		User user=userService.PhoneNumberExists(phone);
		if(user!=null){
			return "*手机号已被注册";
		}else{
			session.setAttribute("unLoginUser",user);
			return "";
		}
	}
	 /**
     * 判断电话号码是否存在。
     * @param phoneNumber
     * @return 提示信息
     */
	@RequestMapping(value="phoneToFindPassword.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String phoneToFindPassword(HttpSession session,@RequestParam(value="phone")String phone){
		User user=userService.PhoneNumberExists(phone);
		if(user!=null){
			session.setAttribute("unLoginUser",user);
			return "";
		}else{
			return "不存在该用户";
		}
	}
	
	 /**
     * 登录之后修改用户信息
     * @param User
     * @return 提示信息
     */
	@RequestMapping(value="modifyInfomation.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String modifyInfomation(User user){
		System.out.println(user);
		Boolean isOk=userService.modifyInfomation(user);
		if(isOk){
			return "";
		}else{
			return "更新失败";
		}
	}
	
	
	 /**
     * 检查答案是否正确。
     * @param answer
     * @return 提示信息
     */
	@RequestMapping(value="checkAnswer.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String checkAnswer(HttpSession session,String answer){
		User user=(User) session.getAttribute("unLoginUser");
		if(user==null||answer==null){
			return "内部错误";
		}else{
			Boolean isRightAnswer=userService.checkAnswer(user.getPhone(), answer);
			if (isRightAnswer) {
				return "";
			}else{
				return "密保问题错误。";
			}
		}
	}
	/**
     * 找回密码时修改密码
     * @param password
     * @return 成功修改界面
     */
	@RequestMapping("findPassword.do")
	public String findPassword(HttpServletRequest request,String password){
		User user=(User)request.getSession().getAttribute("unLoginUser");
		if(user==null){
			request.setAttribute("findPasswordError","更改密码失败，手机号码丢失");
			return "user/forget1.jsp";
		}else{
			Boolean isOk=userService.updatePassword(user.getId(), password);
			if (isOk) {
				return "user/forget_success.jsp";
			}else{
				request.setAttribute("findPasswordError","更改密码失败，出现数据库错误");
				return "user/forget3.jsp";
			}
		}
	}
	
	/**
     * 插入新用户
     * @param User
     * @return 登录界面
     */
	@RequestMapping("insertUser.do")
	public String insertUser(User user){
		Boolean isOk=userService.insertUser(user);
		if(isOk) {
			return "user/register_success.jsp";
		}else {
			return "user/regiser.jsp";
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("loginUser");
		return "index.jsp";
	}
}
