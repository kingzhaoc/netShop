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
<title>验证</title>
		<link rel='stylesheet' type='text/css' href='css/base.css' />
		<link rel="stylesheet" type="text/css" href="css/forget.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

		<script type="text/javascript" src="js/jquery.min.js"></script>

		<script>
			$().ready(function() {
				$("#sub").attr("disabled", "disabled");

				$("#answer").blur(function() {
					$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>checkAnswer.do",
						data : {answer : $(this).val()},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
								if(data != null && data != "") {
									$("#answererror").text(data);
								}else {
									$("#sub").attr("disabled",false);
									$("#answererror").text("");
								}
						}
					});
				});

				$("#sub").click(function() {
					location.href = "pages/user/forget3.jsp";
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
				<div class="form-horizontal myform">
					<div class="form-group">
						<label id="mylabel">
							密码提示问题为: ${unLoginUser.question}
						</label>
					</div>

					<!--答案-->
					<div class="input-group input-group-lg form-group">
						<span class="input-group-addon">&nbsp;&nbsp;答案:&nbsp;</span>
						<input type="text" class="form-control" id="answer" name="answer" maxlength="11" placeholder="请输入密保答案" required="required" />
					</div>
					<div id="answererror" class="error"></div>

					<div class="form-group">
						<button id="sub" type="submit" class="btn btn-primary btn-lg btn-block">下一步</button>
					</div>

				</div>

				<footer>
					Copyright © 2018, Campus Supermarket All Rights Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款
				</footer>
			</div>

		</div>
	</body>

</html>