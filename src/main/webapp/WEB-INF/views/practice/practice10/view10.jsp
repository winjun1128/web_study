<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>practice 10</h1>
	<p>${requestMsg}</p>
	
	
	<c:if test="${B=='false'}">
		<p>${sessionMsgA}</p>
		<p>${sessionMsgB}</p>
	</c:if>
	
	<c:if test="${B=='true'}">
		<p>${sessionMsgB}</p>
	</c:if>
	
</body>
</html>