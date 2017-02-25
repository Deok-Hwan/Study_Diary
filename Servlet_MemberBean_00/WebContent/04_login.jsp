<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 액션 태그의 property 속성 값으로 "*"를 사용하여 손쉽게 요청 파라미터 값을 한꺼번에 자바 빈의 프로퍼티에 저장할수 있습니다. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="04_testLogin.jsp">
	<label for="userid"> 아이디 : </label>
	<input type="text" name ="id" id="userid"><br>
	
	<label for="userid"> 암&nbsp; 호 : </label>
	<input type="text" name ="pwd" id="userpwd"><br>
	
	<input type="submit" value="로그인">
</form>	
</body>
</html>