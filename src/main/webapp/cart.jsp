<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>黑马商城购物车</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>
		<!-- 引入header.jsp -->
		<jsp:include page="/header.jsp"></jsp:include>

		<c:choose>
			<%--如果购物项集合有商品--%>
			<c:when test="${!empty CART.map}">
						<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							
							<%--显示购物车中所有购物项
							    entry是一个Map类型，map-key表示商品编号(Integer)
							                       map-value表示购物项(Item)
							--%>
							<c:forEach var="entry" items="${CART.map}">
								<tr>
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${entry.value.product.pimage}" width="70" height="60">
									</td>
									<td width="30%">
										<a target="_blank">${entry.value.product.pname}</a>
									</td>
									<td width="20%">
										￥${entry.value.product.shop_price}
									</td>
									<td width="10%">
										<%--this.value表示获取input标签的value属性值--%>
										<input
											 type="text" 
											 name="quantity" 
											 value="${entry.value.num}" 
											 maxlength="4" 
											 size="10"
											 onchange="updateProduct(${entry.key},this.value)">
									</td>
									<td width="15%">
										<span class="subtotal">￥${entry.value.subTotal}</span>
									</td>
									<td>
										<a onclick="deleteProduct('${entry.value.product.pname}',${entry.key})" href="#" class="delete">删除</a>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>
			
			<script type="text/javascript">
				//删除购物项
				function deleteProduct(pname,pid){
					//弹出确认框
					var flag = window.confirm("你确定删除【"+pname+"】吗");	
					//如果确认的话
					if(flag){
						//用JS向CartServlet发送请求
						var url = "${pageContext.request.contextPath}/cart?method=deleteProduct&pid="+pid;
						window.location.href = url;
					}
				}
				//更新商品购买数量
				function updateProduct(pid,num){
					var url = "${pageContext.request.contextPath}/cart?method=updateProduct&pid="+pid+"&num="+num;
					window.location.href = url;
				}
			</script>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
			</em> 赠送积分: <em style="color:#ff6600;">
				<fmt:formatNumber value="${CART.total}"/>
			</em>
			&nbsp; 商品金额: <strong style="color:#ff6600;">￥${CART.total}元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a onclick="deleteAllProduct()" href="#" id="clear" class="clear">清空购物车</a>
				</div>
			</div>
			
			<script type="text/javascript">
				//清空购物车
				function deleteAllProduct(){
					var flag = window.confirm("你确认【清空】购物车吗");	
					if(flag){
						var url = "${pageContext.request.contextPath}/cart?method=deleteAllProduct";
						window.location.href = url;
					}
				}
			</script>

		</div>
			</c:when>
			<%--如果购物项集合无商品--%>
			<c:otherwise>
				<center>
					<font style="font-size: 66px">购物车无商品</font>
				</center>
			</c:otherwise>
		</c:choose>

		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>

	</body>

</html>