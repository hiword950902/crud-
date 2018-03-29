<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/pages/Head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <a href="${basePath }/add.do">添加</a>
  <table>
  	<thead>
  		<tr>品牌名</tr>	
  		<tr>品牌描述</tr>
  		<tr>logo</tr>
  		<tr></tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${products }" var="product">
  			<tr>
  				<td>${product.name }</td>
  				<td>${product.description }</td>
  				<td><img height="80" width="80" src="${imgServer }/${product.imgurl }"></td>
  				<td><a href="${basePath }/update.do?id=${product.id }">修改</a>
  				&nbsp;<a href="${basePath }/del.do?id=${product.id }">删除</a></td>
  			</tr>
        </c:forEach>
  	</tbody>
  </table>
  
</body>
</html>