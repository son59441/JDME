<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<h3>EMAIL CHECK</h3>
	<hr>
	<%
	//인증번호 확인
	Object obj = request.getAttribute("authentication_num");
	if (obj == null) return;
	String authnum = obj.toString();
	
	String authnumStr = "메일을 확인 하시고 인증번호를 입력 하시오 ~~ !!";
	System.out.println("emailCheck >>> : " + authnumStr);
	%>
	
	</body>
</html>