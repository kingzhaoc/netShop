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
		<title>商品详情</title>
	
			<link rel="stylesheet" type="text/css" href="css/base.css"/>
			<link rel="stylesheet" type="text/css" href="css/productDetail.css"/>
			
			<script src="<%=basePath %>js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
			<script src="<%=basePath %>js/productdetail.js" type="text/javascript"></script>
			<script src="<%=basePath %>js/jqueryPhoto.js" type="text/javascript"></script>
	</head>	
<body>
<jsp:include page="../commonTop.jsp"/>
	<div id="container">
		<div id="productdetail">
			
			<div id="detail_left">
				<div class="imgbanner">
					<span id="prev" class="btn prev"></span>
					<span id="next" class="btn next"></span>
					<span id="prevTop" class="btn prev"></span>
					<span id="nextTop" class="btn next"></span>
					<div id="picBox" class="picBox">
						<ul class="cf">
							<li><img src="<%=basePath %>upload/${detailData.mainImage}" alt=""></li>
							<li><img src="<%=basePath %>upload/${detailData.subImages[1]}" alt=""></li>
							<li><img src="<%=basePath %>upload/${detailData.subImages[2]}" alt=""></li>
							<li><img src="<%=basePath %>upload/${detailData.subImages[3]}" alt=""></li>
							<li><img src="<%=basePath %>upload/${detailData.subImages[4]}" alt=""></li>
							
						</ul>
					</div>
					<div id="listBox" class="listBox">
						<ul class="cf">
							<li class="on"><i class="arr2"></i><img src="<%=basePath %>upload/${detailData.mainImage}" alt=""></li>
							<li><i class="arr2"></i><img src="<%=basePath %>upload/${detailData.subImages[1]}" alt=""></li>
							<li><i class="arr2"></i><img src="<%=basePath %>upload/${detailData.subImages[2]}" alt=""></li>
							<li><i class="arr2"></i><img src="<%=basePath %>upload/${detailData.subImages[3]}" alt=""></li>
							<li><i class="arr2"></i><img src="<%=basePath %>upload/${detailData.subImages[4]}" alt=""></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			
			<div id="detail_right">
				<div id="detail_right_container">
				
					<%-- <div id="pro_id">
						pro_id:${detailData.product.id}
					</div> --%>
					
					<div id="pro_name">
						${detailData.product.name}
					</div>
					<div id="pro_title">
						${detailData.product.subTitle}
					</div>
					<div class="pro_price">
						<b><span id="yuan">价格： ￥</span><input type="text" id="pro_unitprice" value="${detailData.product.price}" readonly="true">
							
						</input></b>
					</div>
					<div id="pro_stock">
						库存： ${detailData.product.stock} 
					</div>
					
					<div id="pro_num">
						<button type="submit" id="decbtn" class="num_btn"  >-</button>
						<input type="text" id="pro_num_detail" value="1" />
						<button type="submit" id="addbtn" class="num_btn">+</button>
					</div>
					<div class="pro_price">
						<b><span id="yuan">总价： ￥</span><input type="text" id="pro_totalPrice" value="0.00" readonly="true">
							
						</input></b>
					</div>
					<div id="pro_btngroup">
						<button id="addtocart">加入购入车</button>
					</div>
				</div>
				
			</div>
			
			<div class="myclear"></div>
			
		</div>
		
		<div id="productdescribe">
			<h5>商品信息</h5>
			<div id="desc">
				
			</div>
			
			
		</div>
		
	</div>
</body>
</html>