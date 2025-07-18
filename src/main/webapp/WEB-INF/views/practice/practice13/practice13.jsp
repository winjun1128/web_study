<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.ad{
		width:100%;
		background-color:RGB(165,42,42);
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${view ==!true||view==null}">
			<form action="" method="post">
				<div class="ad">
					<input type="checkbox" name="closechk" value="chk">24시간 보지 않기
					<button name="closebtn" value="push">닫기</button>
				</div>
			</form>
		</c:when>
	</c:choose>
</body>
</html>