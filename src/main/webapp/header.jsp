﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="resources/img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="resources/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			
			欢迎${!empty USER?USER.username:"游客"}光临
			<c:choose>
				<%--如果登录了
				    ${!empty USER}表示User!=null
				--%>
				<c:when test="${!empty USER}">
					<li><a href="cart.jsp">购物车</a></li>
					<li><a href="${pageContext.request.contextPath}/user/logout">退出</a></li>
				</c:when>
				<%--如果没登录--%>
				<c:otherwise>
					<li><a href="login.jsp">登录</a></li>
					<li><a href="register.jsp">注册</a></li>
				</c:otherwise>
			</c:choose>

		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/default.jsp">首页</a>
			</div>                              

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="ul">
				     <li><a href="${pageContext.request.contextPath}/product/findAllProductByCid?cid=1">手机数码</a></li>
				     <li><a href="${pageContext.request.contextPath}/product/findAllProductByCid?cid=2">电脑平板</a></li>
				     <li><a href="${pageContext.request.contextPath}/product/findAllProductByCid?cid=3">女士服装</a></li>
				     <li><a href="${pageContext.request.contextPath}/product/findAllProductByCid?cid=4">男士服装</a></li> 
				     <li><a href="${pageContext.request.contextPath}/product/findAllProductByCid?cid=4">鞋帽箱包</a></li> 
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>