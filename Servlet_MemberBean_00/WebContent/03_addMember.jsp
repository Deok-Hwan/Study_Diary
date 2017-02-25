<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />
<jsp:setProperty property="*" name="member" />

<!-- 액션 태그의 property 속성 값으로 "*"를 사용하여 손쉽게 요청 파라미터 값을 한꺼번에 자바 빈의 프로퍼티에 저장할수 있습니다. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
			<tr>
				<td>이름</td>
				<td><jsp:getProperty property="name" name="member"/>
			</tr>
			<tr>
				<td>아이디</td>
				<td><jsp:getProperty property="userid" name="member"/>
			</tr>
			<tr>
				<td>별명</td>
				<td><jsp:getProperty property="nickname" name="member"/>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><jsp:getProperty property="pwd" name="member"/>
			</tr>
			<tr>
				<td>이메일</td>
				<td><jsp:getProperty property="email" name="member"/>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><jsp:getProperty property="phone" name="member"/>
			</tr>
			
		</table>
</body>
</html>