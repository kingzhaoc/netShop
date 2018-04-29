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
		<title>注册成功</title>

		<link rel='stylesheet' type='text/css' href='<%=basePath%>/css/base.css' />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/forget.css" />
		<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css" />

		<script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>

	</head>

	<body>
		<div id="container">
			<div class="mybody">
				<div class="=logo">
					<div class="heading">注册成功</div>
				</div>

				<!--表单-->
				<div class="form-horizontal myform">
					<div class=" form-group myphoto" >
						<img src="images/forget_success.png" />
					</div>
					<div class=" form-group " id="mytitle">
						你已成功注册我网会员
					</div>
					
					<div class=" form-group myhref" id="myhref">
						<p><span>前往登录<a id="href" href="pages/user/login.jsp">跳转</a></span><span>等待<b id="wait">6</b>秒</span></p>
						<script type="text/javascript">                            
							(function() {
								var wait = document.getElementById('wait'), href = document.getElementById('href').href;
								var interval = setInterval(function() {
									var time = --wait.innerHTML;
									if (time <= 0) {
										location.href = href;
										clearInterval(interval);
									}
									;
								}, 1000);
							})();
						</script>
					</div>
				</div>

				<footer>
					Copyright © 2018, Campus Supermarket All Rights Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款
				</footer>
			</div>
		</div>
	</body>

</html>