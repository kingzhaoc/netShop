<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
		
		<link rel='stylesheet' type='text/css' href='css/base.css' />
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			    $("#phone").blur(function(){
			    	$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>phoneToFindPassword.do",
						data : {phone : $(this).val()},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
								if(data != null && data != "") {
									$("#phoneerror").text(data);
									$("#sub").attr("disabled",true);
								}else {
									$("#sub").attr("disabled",false);
									$("#phoneerror").text("");
								}
								
						}
						
					});
			    });
			});
			

		</script>
	</head>
	<body>
		<div id="container">
			<div id="l_body">
				<div id="loginlogo">
					<div id="heading">用户登录</div>
				</div>
				
				<!--登陆表单-->
				<form action="checkPassword.do" method="post" id="loginform" class="form-horizontal">
					
			        <div class="input-group input-group-lg form-group">
			            <span class="input-group-addon">手机号:</span>
			            <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号" value="${phone }" required="required"/>
			        </div>
			        <div id="phoneerror" class="error"></div>
        			<br>
       
					<div class="input-group input-group-lg form-group">
			            <span class="input-group-addon">&nbsp;密&nbsp;&nbsp;码:</span>
			            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required="required"/>
			        </div>
			        <div id="passworderror" class="error">${loginFail }</div>
        			<br>
					
					<div class="form-group" style="float: right;">
						<a href="pages/user/register.jsp">注册会员</a> | <a href="pages/user/forget1.jsp">忘记密码？</a>
					</div>
					<div class="form-group">
						<button id="sub" type="submit" class="btn btn-primary btn-lg btn-block">登陆</button>
					</div>		
					
				</form>
			</div>
			<footer>
				Copyright © 2018, Campus Supermarket All Rights Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款
			</footer>
		</div>
	</body>
</html>
