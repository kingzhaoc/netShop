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
	<title>首页</title>

		<link rel='stylesheet' type='text/css' href='css/base.css' />
		<link rel='stylesheet' type='text/css' href='css/home.css' />
		<link type="text/css" href="css/autoplay.css" rel="stylesheet" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/floor.js"></script>
		<script type="text/javascript" src="js/autoplay.js"></script>
		
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
<base href="<%=basePath %>">
		<jsp:include page="./commonTop.jsp"/>
		<div id='container'>

			<!-- 开始  身体部分   从这里到下面可以看成一个整体 -->
			<div class='s-body'>
				<!-- 首页轮播图  start -->
				<div id="box_autoplay">
			    	<div class="list">
			        	<ul>
			            	<li><img src="images/index/banner.jpg" class="imgstyle"  /></li>
			            	<li><img src="images/index/banner3.jpg" class="imgstyle" /></li>
			            	<li><img src="images/index/banner2.jpg" class="imgstyle" /></li>
			            	<li><img src="images/index/banner.jpg" class="imgstyle" /></li>
			            	<li><img src="images/index/banner3.jpg" class="imgstyle" /></li>
			        	</ul>
			    	</div>
				</div>
				<!-- 首页轮播图  end -->

				<!-- 	开始  小区快 -->
				<div class='s-block'>
					<ul class='s-b-list clearfix'>
						<li>
							<a href="#"><img src="images/4-main-1/1.jpg" alt="" /></a>
						</li>
						<li>
							<a href="#"><img src="images/4-main-1/2.jpg" alt="" /></a>
						</li>
						<li>
							<a href="#"><img src="images/4-main-1/3.jpg" alt="" /></a>
						</li>
						<li class='s-b-ls-1'>
							<a href="#"><img src="images/4-main-1/4.png" alt="" /></a>
						</li>
					</ul>

				</div>
				<!-- 小区快 结束 -->

				<div class="louceng_box">
					<!-- 开始  热门商品 -->
					<div class='s-commodity louceng'>
						<h5>热门商品
						</h5>
						<ul class='s-c-list clearfix'>
							<c:forEach var="hotpro" items="${homePageData[0].products}" varStatus="proindex">
							<c:choose> 
								<c:when test="${proindex.index == 3 }">
								<li class='s-c-ls-4'>
								<a><img src="<%=basePath %>upload/${hotpro.mainImage}" alt="" /></a>
								<div>
									<h6>${hotpro.name}</h6>
									<p>${hotpro.subTitle}</p>
								</div>
								<ul class='clearfix'>

								</ul>
								<div>
									<span>￥${hotpro.price}</span>
									<a href="<%=basePath %>productDetail.do?productId=${hotpro.id}" class='s-c-list-btn1'>查看详情</a>
									<a href="#" class='s-c-list-btn2 a_addToCart'>加入购物车</a>
								</div>
								<div class="pro_id_forcart" style="display:none">${hotpro.id}</div>
							</li>
							  </c:when>
							  <c:otherwise>
							  <li>
								<a><img src="<%=basePath %>upload/${hotpro.mainImage}" alt="" /></a>
								<div>
									<h6>${hotpro.name}</h6>
									<p>${hotpro.subTitle}</p>
								</div>
								<ul class='clearfix'>

								</ul>
								<div>
									<span>￥${hotpro.price}</span>
									<a href="<%=basePath %>productDetail.do?productId=${hotpro.id}" class='s-c-list-btn1'>查看详情</a>
									<a href="#" class='s-c-list-btn2 a_addToCart'>加入购物车</a>
								</div>
								<div class="pro_id_forcart" style="display:none">${hotpro.id}</div>
							</li>
							  </c:otherwise> 
							  
							 </c:choose> 
							</c:forEach>	
							
						</ul>
					</div>
					<!-- 热门商品  结束 -->

					<!-- 零食 开始 -->
					<c:forEach var="categoryName" items="${homePageData}" begin="1">
						<div class='s-commodity louceng'>
							<h5>${categoryName.categoryName}
								<a href="<%=basePath %>showMore.do?categoryId=${categoryName.categoryId}&categoryName=${categoryName.categoryName}"><span>更多</span></i></a>
							</h5>
							<ul class='s-c-list clearfix'>
								<c:forEach var="product" items="${categoryName.products}" varStatus="proindex">
									<c:choose>
										<c:when test="${proindex.index == 0 }">
											<li class='s-c-ls-1'>
												<a href="<%=basePath %>productDetail.do?productId=${product.id}">
												<img src="<%=basePath %>upload/${product.mainImage}" alt="" />
												</a>
											</li>
										</c:when>
										<c:when test="${proindex.index == 2}">
											<li class='s-c-ls-4 s-c-ls-2'>
												<a><img src="<%=basePath %>upload/${product.mainImage}" alt="" /></a>
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
										</c:when>
										
										<c:when test="${proindex.index == 6}">
											<li class='s-c-ls-4'>
												<a><img src="<%=basePath %>upload/${product.mainImage}" alt="" /></a>
												<div>
													<h6>${product.name}</h6>
													<p>${product.subTitle}</p>
												</div>
												<ul class='clearfix'>
				
												</ul>
												<div>
													<span>￥${product.price}</span>
													<a href="<%=basePath %>productDetail.do?productId=${product.id}" class='s-c-list-btn1'>查看详情</a>
													<a href="#" class='s-c-list-btn2 a_addToCart'>加入购物车</a>
												</div>
												<div class="pro_id_forcart" style="display:none">${product.id}</div>
											</li>
										</c:when>
										
										<c:otherwise>
											<li class='s-c-ls-2'>
												<a><img src="<%=basePath %>upload/${product.mainImage}" alt="" /></a>
												<div>
													<h6>${product.name}</h6>
													<p>${product.subTitle}</p>
												</div>
												<ul class='clearfix'>
				
												</ul>
												<div>
													<span>￥${product.price}</span>
													<a href="<%=basePath %>productDetail.do?productId=${product.id}" class='s-c-list-btn1'>查看详情</a>
													<a href="#" class='s-c-list-btn2 a_addToCart'>加入购物车</a>
												</div>
												<div class="pro_id_forcart" style="display:none">${product.id}</div>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</div>
					<!-- 零食 结束 -->
						
					</c:forEach>
				</div>
			</div>
			<!-- 身体部分  结束 -->

		</div>

		<!--右侧固定导航-->
		<ul class="fixedmeau" style="display: block;">
			<li class="active"><i>1F</i><span>热销</span></li>
			<c:forEach var="categoryName" items="${homePageData}" begin="1" varStatus="floorindex">
				<li><i>${floorindex.count + 1 }F</i><span>${categoryName.categoryName}</span></li>
			</c:forEach>
			
			
		</ul>
		
		<!--返回顶部-->
		<div class="totop" style="display: block;"><span>▲</span>Top</div>

		<script type="text/javascript">
			/*
					    totop  			//返回顶部按钮
					    fixedevery      // 左侧固定导航的每一项
					    louceng         /模块的每一项
					    */
			$(function() {
				var obj = new floor('.totop', '.fixedmeau>li', '.louceng_box>.louceng');
				obj.init()
			})
		</script>

</body>
</html>