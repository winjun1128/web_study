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
	<h1>관리자 페이지</h1>
	<h2>객실 상세 설명 페이지</h2>
	
	<p>${room.roomId} ${room.buildingName} ${room.roomNumber} ${room.floor} ${room.maxGuestCount} 
		
		<c:choose>
			<c:when test="${room.viewType == 'OCN'}">오션뷰</c:when>
			<c:when test="${room.viewType == 'CTY'}">시티뷰</c:when>
			<c:when test="${room.viewType == 'MOT'}">마운틴뷰</c:when>
		</c:choose>
	</p>
	
	<div>
		<button type="button" onClick="location.href='/admin/rooms'">객실 목록보기</button>
	</div>
	
	<script>
	</script>
	
</body>
</html>