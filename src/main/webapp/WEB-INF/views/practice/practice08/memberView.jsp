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
	<c:forEach var="basic" items="${basicList }">
		<p>${basic.id } ${basic.pw } ${basic.name } ${basic.type }</p>
	</c:forEach>
	<c:forEach var="manager" items="${managerList }">
		<p>${manager.id } ${manager.pw } ${manager.name } ${manager.type }</p>
	</c:forEach>
	<c:forEach var="member" items="${memberList }">
		<p>${member.id } ${member.pw } ${member.name } ${member.type }</p>
	</c:forEach>
</body>
</html>