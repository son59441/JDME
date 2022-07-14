<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="jdme.member.vo.JDMEMemberVO"%>
<%@page import="org.apache.log4j.LogManager" %>
<%@page import="org.apache.log4j.Logger" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("jdmeMainPage.jsp 진입 >>> : ");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- 실패한 메인 css -->
		<!-- <link href="resources/css/main.css" rel="stylesheet"> -->
		<!-- 실패한 메인 js -->
		<!--<script type ="text/javascript" src="resources/js/main.js"> </script>-->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		
	</head>
	<body>
    <%@include file ="/WEB-INF/include/header_test2.jsp" %>
   
  	
	<div id="subs_meta" class="content">
		<h1><a href="#">1</a></h1>
	</div>
	
	<div id="wine_reco_meta" class="content">
		<h1>2</h1>
	</div>
	
	<div id="shop_meta" class="content">
		<h1>3</h1>
	</div>
	
	<div id="comm_meta" class="content">
		<h1>4</h1>
	</div>
	</body>
</html>