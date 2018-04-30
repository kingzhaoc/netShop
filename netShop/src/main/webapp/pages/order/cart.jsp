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

		<link rel='stylesheet' type='text/css' href='css/cart.css' />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel='stylesheet' type='text/css' href='css/base.css' />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		
		<script type="text/javascript">
			
			$(document).ready(function(){
				sumPrice();
				var quantityNode=null;
				var deleteNode=null;
				var changeSelectNode=null;
				
			    $(".addbtn").click(function(){
			    	var cartId = $(this).attr("name");
			    	quantityNode=$(this).prev();
			    	$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>updateQuantity.do",
						data : {cartId:cartId,isAdd:true},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
							quantityNode.val(data);
							sumPrice();
						}
					});
			    });
 				$(".decbtn").click(function(){
 					var cartId = $(this).attr("name");
			    	quantityNode=$(this).next();
			    	$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>updateQuantity.do",
						data : {cartId:cartId,isAdd:false},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){	
							quantityNode.val(data);
							sumPrice();
						}
					});
			    });
 				
				$(".changechecked").click(function(){
					changeSelectNode=$(this);
					var cartId = $(this).parent().parent().attr("name");
					$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>changeSelect.do",
						dataType : "text",
						data : {cartId:cartId},
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){	
							sumPrice();
						}
					});		    	
				});
				$("#checkall").click(function(){
					var checked=$(this).prop("checked");
					$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>selectAllOrNot.do",
						data : {isSelectAll:checked},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
							if(data=="1"){
								$(".changechecked").prop("checked",true);
							}else{
								$(".changechecked").prop("checked",false);
							}
							sumPrice();
						}
					});
				});

				$(".a_delete").click(function(){
					var cartId = $(this).attr("name");
					deleteNode=$(this).parent().parent();
					number=parseInt(cartId);
 					$.ajax({
					 	type: "POST",
					  	url: "<%=basePath%>deleteCart.do",
						data : {cartId:number},
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8", 
						success : function(data){
							deleteNode.remove();
							sumPrice();
						}
					});
 					return false;
				});
				$(".a_deleteAll").click(function(){
					var statu = confirm("是否删除选中的商品");
					if(!statu){
						return false;
					}else{
						location.href="<%=basePath%>deleteSelectedItem.do";
					}
					return false;
				}); 
			});
			
			//计算价格
			function sumPrice(){
				var sum=0.0;
				$(".cartLine").each(function(){
					var singlePrice=$(this).children().find(".singlePrice").val();
					var number=$(this).children().find(".pronum").val();
					sPrice=parseFloat(singlePrice);
					number=parseFloat(number);
					var price=sPrice*number;
					$(this).children().find(".price").val(price.toFixed(2));
					sum+=price;
				});
				$("#totalprice").val(sum.toFixed(2));
			}
		</script>
		
</head>
<body>
<base href="<%=basePath %>">
		<jsp:include page="../commonTop.jsp"/>
		<div id="container">
			
			<div class='s-commodity'>
				<h5>购物清单</h5>
				
				<c:choose>
					<c:when test="${empty cartData }">
						<div id="nopro">
						
							<div id="nopro_info">
								您的购物车中还没有商品</br>
								<a href="<%=basePath %>index.jsp"><button id="buybtn">现在选购</button></a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div id="procart">
						<table class="table table-striped  table-hover table-condensed">
							<thead>
							<tr>
								<th ></th>
								<th >商品信息</th>
								<th >单价(单位：元)</th>
								<th >数量</th>
								<th >小计(单位：元)</th>
								<th >操作</th>
							</tr>
							</thead>
							<tbody>
						<c:forEach var="proItem" items="${cartData }">
							<tr name="${proItem.cart.id}" class="cartLine">
								<c:if test="${proItem.cart.checked == 0 }">
								<td class="pro_choose"><input class="changechecked" type="checkbox" /></td>
								</c:if>
								<c:if test="${proItem.cart.checked == 1 }">
								<td class="pro_choose"><input class="changechecked" type="checkbox" checked="checked" /></td>
								</c:if>
								<td class="pro_info">
									<img class="pro_img" src="<%=basePath %>upload/${proItem.mainImage }"/>
									<div class="pro_name" >
										<b >${proItem.name }</b><br>
										<span class="pro_title">${proItem.subTitle }</span>
									</div>
									
								</td>
								<td class="pro_unitprice"><input type="text" class="pro_price_info singlePrice" value="${proItem.singlePrice } " readonly="true"></td>
								<td class="pro_num">
									<button type="submit" name="${proItem.cart.id}" class="num_btn decbtn" >-</button>
									<input type="text" class="pro_num_detail pronum" value="${proItem.cart.quantity }" readonly="true" />
									<button type="submit" name="${proItem.cart.id}" class="num_btn addbtn">+</button>
								</td>
								<td name="sumPrice" class="pro_price"><input type="text" class="pro_price_info price" value="${proItem.sumPrice}" readonly="true"></td>
								<td class="pro_opre"><a class="a_delete" name="${proItem.cart.id} href="">删除</a></td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						
						<div id="procart">
					
							<div class="cart_bottom">
								<input type="checkbox" name="" id="checkall" value="" />&nbsp;全选&nbsp;&nbsp;|&nbsp;
								<a href="" class="a_deleteAll" style="text-decoration: none;">删除选中的商品</a>
								
								<button class="btn btn-primary btn-lg btn-block" id="bottom_placeorder">现在结算</button>
								<b>
									<span id="bottom_totalprice">应付总额:￥<input type="text" id="totalprice" value="" readonly="true"></input></span>
								</b>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
	
			</div>
		</div>
</body>
</html>