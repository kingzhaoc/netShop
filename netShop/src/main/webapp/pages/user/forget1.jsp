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
	<title>忘记密码</title>

		<link rel='stylesheet' type='text/css' href='css/base.css' />
		<link rel="stylesheet" type="text/css" href="css/forget.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />

		<script type="text/javascript" src="js/jquery.min.js"></script>

		<script>
			$().ready(function() {
				$("#sub").attr("disabled", "disabled");

				$("#phone").blur(function() {
					$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>phoneToFindPassword.do",
						data : {phone : $(this).val()},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
								if(data != null && data != "") {
									$("#phoneerror").text(data);
								}else {
									$("#sub").attr("disabled",false);
									$("#phoneerror").text("");
								}
								
						}
						
					});
				});

				$("#sub").click(function() {
					location.href = "pages/user/forget2.jsp";
				})
			})
		</script>

	</head>

	<body>
		<div id="container">
			<div class="mybody">
				<div class="=logo">
					<div class="heading">忘记密码</div>
				</div>

				<!--表单-->
				<div class="form-horizontal myform">
					<!--手机号-->
					<div class="input-group input-group-lg form-group">
						<span class="input-group-addon">&nbsp;&nbsp;手机号:&nbsp;</span>
						<input type="text" class="form-control" id="phone" name="phone" maxlength="11" placeholder="请输入手机号" required="required" />
					</div>
					<div id="phoneerror" class="error">${findPasswordError}</div>

					<div class="form-group">
						<button id="sub" type="submit" class="btn btn-primary btn-lg btn-block">下一步</button>
					</div>

					</vid>
				</div>
				<footer>
					Copyright © 2018, Campus Supermarket All Rights Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款
				</footer>
			</div>
		</div>
	</body>

</html>