<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel='stylesheet' type='text/css' href='<%=basePath%>/css/base.css' />
<link rel="stylesheet" href="<%=basePath%>/css/register.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/bootstrap.css" />

<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	$().ready(function() {
		var isPasswordValid=false;
		var isPhoneValid=false;
		$("#phone").blur(function(){
			$.ajax({
			 	type: "POST",
			  	url: "<%=basePath%>/phoneNumberExists.do",
				data : {phone : $(this).val()},
				dataType : "text",
				contentType : "application/x-www-form-urlencoded;charset=utf-8", 
				success : function(data){
						if(data != null) {
							$("#phoneerror").text(data);
					    	isPhoneValid=true;
						}else {
							isPhoneValid=false;
							$("#phoneerror").text("");
						}
						if(isPasswordValid&&isPhoneValid){
						$("#sub").removeAttr("disabled");
					}else{
						$("#sub").attr("disabled","disabled");
					}
				},
				
			});
		});

		$("#comfirmpd").blur(function() {
			var str1 = $("#password").val();
			var str2 = $(this).val();
			if (str1 != str2) {
				isPasswordValid = false;
				$("#comfirmpderror").text("*密码不一致");

			} else {
				isPasswordValid = true;
				$("#comfirmpderror").text("");
			}
			if (isPasswordValid && isPhoneValid) {
				$("#sub").removeAttr("disabled");
			} else {
				$("#sub").attr("disabled", "disabled");
			}
		});
	});
</script>
</head>
<body>
	<div id="container">
		<div id="r_body">
			<div id="registerlogo">
				<div id="heading">用户注册</div>
			</div>
			
			<!--注册表单-->
			<form action="<%=basePath%>/insertUser.do" method="post" id="registerform"
				class="form-horizontal">
				<!--手机号-->
				<div class="input-group input-group-lg form-group">
					<span class="input-group-addon">&nbsp;&nbsp;手机号:&nbsp;</span> <input
						type="text" class="form-control" id="phone" name="phone"
						maxlength="11" placeholder="请输入手机号" required="required" />
				</div>
				<div id="phoneerror" class="error"></div>

				<!--用户名-->
				<div class="input-group input-group-lg form-group">
					<span class="input-group-addon">&nbsp;&nbsp;用户名:&nbsp;</span> <input
						type="text" class="form-control" id="username" name="username"
						placeholder="请输入用户名" required="required" />
				</div>

				<!--密码-->
				<div class="input-group input-group-lg form-group">
					<span class="input-group-addon">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;</span>
					<input type="password" class="form-control" id="password"
						name="password" placeholder="请输入密码" required="required" />
				</div>

				<!--确认密码-->
				<div class="input-group input-group-lg form-group">
					<span class="input-group-addon">确认密码:</span> <input type="password"
						class="form-control" id="comfirmpd" name="comfirmpd"
						placeholder="请再次输入密码" required="required" />
				</div>
				<div id="comfirmpderror" class="error"></div>

				<!--密保问题-->
				<div class="input-group input-group-lg form-group">
					<span class="input-group-addon">密保问题:</span> <input type="text"
						class="form-control" id="question" name="question"
						placeholder="请输入密保问题" required="required" />
				</div>

				<!--密保答案-->
				<div class="input-group input-group-lg form-group">
					<span class="input-group-addon">密保答案:</span> <input type="text"
						class="form-control" id="answer" name="answer"
						placeholder="请输入密保答案" required="required" />
				</div>

				<!--勾选-->
				<div class="input-group input-group-lg form-group">
					<input class="checkbox-inline" type="checkbox" id="xieyi"
						required="required">阅读并同意<a href="">《用户注册协议》</a><a href="">《隐私政策》</a>
				</div>

				<div class="form-group">
					<button id="sub" type="submit"
						class="btn btn-primary btn-lg btn-block">注册</button>
				</div>

				<div class="form-group" id="havedid">
					如果您已拥有账号，则可在此<a href="pages/user/login.jsp">登录</a>
				</div>

			</form>
		</div>
		<footer> Copyright © 2018, Campus Supermarket All Rights
		Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款 </footer>
	</div>
</body>
</html>
