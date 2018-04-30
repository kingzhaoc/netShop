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
<title>商品列表</title>

<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/productList.css" />
		
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			    $(".a_addToCart").click(function(){
			    	var id = $(this).parent().next().text();
			    	$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>addCart.do",
						data : {productId : id,quantity:1},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
								if(data == "") {
									var statu = confirm("添加成功，是否前往购物车");
									if(!statu){
										return false;
									}else{
										location.href="<%=basePath%>lookCart.do";
									}
								}
								if(data =="错误，请先登录"){
									var statu = confirm(data);
									if(!statu){
										return false;
									}else{
										location.href="<%=basePath%>pages/user/login.jsp";
									}
								}	
						}
					});
			    });
			});
		</script>
</head>
<body>
<jsp:include page="../commonTop.jsp"/>
<div id="container">
			
			<div class='s-commodity'>
				<h5>${name }
							
				</h5>
				<ul class='s-c-list clearfix'>
					<c:if test="${empty pageData}">
						<div></div>
					</c:if>
					<c:forEach var="product" items="${pageData.productList }">
						<li class='s-c-ls-2'>
						<a href=""><img src="<%=basePath %>upload/${product.mainImage}" alt="" /></a>
						<div>
							<h6>${product.name}</h6>
							<p>${product.subTitle}</p>
						</div>
						<ul class='clearfix'>

						</ul>
						<div>
							<span>￥${product.price}</span>
							<a href="<%=basePath %>productDetail.do?productId=${product.id}" class='s-c-list-btn1'>查看详情</a>
							<a href="" class='s-c-list-btn2 a_addToCart'>加入购物车</a>
						</div>
						<div class="pro_id_forcart" style="display:none">${product.id}</div>
					</li>
					
					</c:forEach>
		
				</ul>
			</div>
			
			
			<div id="pageindex">
				<c:if test="${pageData.maxPage == 1 }">
				共1页
				</c:if>
				<c:if test="${empty pageData }">
				
				</c:if>
				<c:if test="${pageData.maxPage > 1 }">
					<c:if test="${pageData.categoryId != -1 }">
						<a href="<%=basePath %>changePageWithCategory.do?categoryId=${pageData.categoryId }&newPage=1">首页</a>
						<a href="changePageWithCategory.do?categoryId=${pageData.categoryId }&newPage=${pageData.currentPage-1 }">上一页</a>
						${pageData.currentPage }
						<a href="changePageWithCategory.do?categoryId=${pageData.categoryId }&newPage=${pageData.currentPage+1 }">下一页</a>
						<a href="changePageWithCategory.do?categoryId=${pageData.categoryId }&newPage=${pageData.maxPage }">末页</a>
						共${pageData.maxPage }页
					</c:if>
					<c:if test="${pageData.categoryId == -1 }">
					<a href="<%=basePath %>changePageWithKeyword.do?keyword=${name }&newPage=1">首页</a>
					<a href="changePageWithKeyword.do?keyword=${name }&newPage=${pageData.currentPage-1 }">上一页</a>
					${pageData.currentPage }
					<a href="changePageWithKeyword.do?keyword=${name }&newPage=${pageData.currentPage+1 }">下一页</a>
					<a href="changePageWithKeyword.do?keyword=${name }&newPage=${pageData.maxPage }">末页</a>
					共${pageData.maxPage }页
					</c:if>
				</c:if>
			</div>
		</div>

</body>
</html>