<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/JsonpAjax.js" type="text/javascript" charset="utf-8"></script>
		
		<script>
		$(document).ready(function(){
			$(".a_cart").click(function(){
				$.ajax({
				 	type: "POST",
				  	url: "checkLogin.do",
					dataType : "text",
					contentType : "application/x-www-form-urlencoded;charset=utf-8", 
					success : function(data){
						if(data == ""){
							location.href="<%=basePath%>lookCart.do";
						}else{
							var statu = confirm(data);
							if(!statu){
								return false;
							}else{
								location.href="<%=basePath%>pages/user/login.jsp";
							}
						}
					}	
				});
				return false;
			});
			
			$(".a_info").click(function(){
				$.ajax({
				 	type: "POST",
				  	url: "checkLogin.do",
					dataType : "text",
					contentType : "application/x-www-form-urlencoded;charset=utf-8", 
					success : function(data){
						if(data == ""){
							location.href="<%=basePath%>pages/user/userInfo.jsp";
						}else{
							var statu = confirm(data);
							if(!statu){
								return false;
							}else{
								location.href="<%=basePath%>pages/user/login.jsp";
							}
						}
					}	
				});
				return false;
			});
			
			$(".a_order").click(function(){
				$.ajax({
				 	type: "POST",
				  	url: "checkLogin.do",
					dataType : "text",
					contentType : "application/x-www-form-urlencoded;charset=utf-8", 
					success : function(data){
						if(data == ""){
							location.href="<%=basePath%>pages/order/order.jsp";
						}else{
							var statu = confirm(data);
							if(!statu){
								return false;
							}else{
								location.href="<%=basePath%>pages/user/login.jsp";
							}
						}
					}	
				});
				return false;
			});
			
			$(".a_logout").click(function(){
				var statu = confirm("亲爱的用户，你是否想注销登录！");
				if(!statu){
					return false;
				}else{
					location.href="<%= basePath%>logout.do";
				} 
				return false;
			});
			
		})
		</script>
</head>
<body>
<div id="top_container">
			<!--顶部信息-->
			<div id="top_info">
				<div id="second_top_info">
					<!--左边登录-->
					<div id="second_top_info_left">
						<c:choose>
							<c:when test="${empty loginUser}">
								<a href="<%= basePath%>pages/user/login.jsp">登录</a><a href="<%= basePath%>pages/user/register.jsp"">注册</a>
							</c:when>
							<c:otherwise>
								欢迎，${loginUser.username} <a class="a_logout" href="#">退出</a>
							</c:otherwise>
						</c:choose>
				
					</div>
					
					<!--右边个人-->
					<div id="second_top_info_right">
						<a class="a_cart" href="#">购物车</a>
						<a class="a_order" href="#">我的订单</a>
						<a class="a_info" href="#">我的信息</a>
					</div>
					
					<div class="clear"></div>
				</div>
			</div>
			
			<!-- 商标加搜索-->
			<div id="brand">
				<div id="second_brand">
					<!--左边商标-->
					<div id="left_logo">
						<div id="left_logo_info">
							<a href=""><img src="images/logo.png"/></a>
						</div>
					</div>
						
					<!--右边搜索-->
					<div id="right_search">
						<div id="searchform">
							<form class="search" action="searchProducts.do" method="post">
					  			<input type="text" id="textinput" name="keyword" required="required" placeholder="搜索从这里开始...">
					  			<button type="submit"><b><h3>Serch</h3></b></button>
					  			<div id="wordtable" ></div>
							</form>
						</div>
					</div>
				
					<div class="clear"></div>
					
				</div>
				
			</div>
		</div>
</body>
</html>