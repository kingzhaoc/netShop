<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改密码</title>
		<link rel='stylesheet' type='text/css' href='css/base.css' />
		<link rel="stylesheet" type="text/css" href="css/forget.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

		<script type="text/javascript" src="js/jquery.min.js"></script>

		<script>
			$().ready(function() {
				$("#sub").attr("disabled", "disabled");

				$("#comfirmpd").blur(function() {
					var str1 = $("#password").val();
					var str2 = $(this).val();
					if(str1 != str2) {
						$("#comfirmpderror").text("*密码不一致");
						$("#sub").attr("disabled", "disabled");
					} else {
						$("#comfirmpderror").text("");
						$("#sub").removeAttr("disabled");
					}
				});
				$("#sub").click(function() {
					location.href = "forget_success.html";
				})
			})
		</script>

	</head>

	<body>
		<div id="container">
			<div class="mybody">
				<div class="=logo">
					<div class="heading">找回密码</div>
				</div>

				<!--表单-->
				<form action="findPassword.do" method="post" class="form-horizontal myform">
					
					<!--密码-->
					<div class="input-group input-group-lg form-group">
						<span class="input-group-addon">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;</span>
						<input type="password" class="form-control" id="password" name="password" placeholder="请输入新密码" required="required" />
					</div>

					<!--确认密码-->
					<div class="input-group input-group-lg form-group">
						<span class="input-group-addon">确认密码:</span>
						<input type="password" class="form-control" id="comfirmpd" name="comfirmpd" placeholder="请再次输入密码" required="required" />
					</div>
					<div id="comfirmpderror" class="error"></div>

					<div class="form-group">
						<button id="sub" type="submit" class="btn btn-primary btn-lg btn-block">重置</button>
					</div>

				</form>
				<footer>
					Copyright © 2018, Campus Supermarket All Rights Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款
				</footer>
			</div>
		</div>
	</body>

</html>