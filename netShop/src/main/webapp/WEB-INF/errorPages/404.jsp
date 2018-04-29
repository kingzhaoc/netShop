<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/404.css" />

</head>
<body>
	<div class="error_content">

		<div class="error_left">
			<span class="sp_con">赶紧修，大家等着呢。</span>
		</div>

		<div class="error_right">

			<div class="error_detail">
				<p class="error_p_title">哎呦~ 服务器居然累倒了!</p>
				<p class="error_p_con">●别急，工程师正在紧急处理，马上就好。</p>
				<p class="error_p_con">●您可致电010-*****转8169,***通知***开发人员!</p>
				<p class="error_p_con">●***的进步需要您的反馈,感谢您对***的使用,请您耐心等待!</p>
			</div>

			<div class="btn_error">
				<a class="btn_back1" href="<%=basePath%>/index.jsp">返回首页</a> <a
					class="btn_back2"
					href="javascript:history.go(-1);location.reload()">返回上一页</a>
			</div>

		</div>
	</div>
	<footer> Copyright © 2018, Campus Supermarket All Rights
		Reserved.四川师范大学计科学院黑夜梦想家 | 法律声明 | 隐私条款 </footer>
</body>
</html>
