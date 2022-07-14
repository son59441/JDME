<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.io.PrintWriter" %>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("======멤버인서트폼.jsp입장======");

	//세션체크 후 이미 로그인 했으면 회원가입 못하게 막기
	String KID = null;
	if(session.getAttribute("KID")!=null){
		KID = (String)session.getAttribute("KID");
		//없으면 null이 뜰 것이다.
	}
	if(KID!=null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인 중 입니다.');");
		script.println("history.go(-1)");
		script.println("</script>");
	}	

	


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				alert("ready");
				
				//아이디 중복체크 시작 =================================
				$("#midbtn").click(function(){
					console.log("idCheck >>> : ");
					
					let midVal = $("#jmid").val();
					if(midVal==''){
						alert("중복 체크 할 아이디를 입력하세요 >>> : ");
						$("#jmid").focus();
						return false;
					}
				});//endofclick
				//아이디 중복체크 Ajax 비동기 방식
				$(document).on("click","#jmidbtn",function(){
					alert("jmidbtn 버튼클릭확인 ");
					
					let idCheckURL = "jdmeIdCheck.jdme"
					let reqType = "POST";
					let dataParam = {jmid:$("#jmid").val(),};
					
					$.ajax({
						url : idCheckURL,
						type : reqType,
						data : dataParam,
						success : whenSuccess,
						error : whenError
					});
					
					function whenSuccess(resData){
						if("ID 사용가능"==resData){
							alert("아이디 사용가능 : ID_YES");
							$("#jmid").css('background-color','yellow');	
							$("#jmid").attr("readonly", true);
							$("#jmpw").focus();	
						}else if("ID 중복"==resData){
							alert("이미 아이디 사용중 : ID_NO.");
							$("#jmid").val('');
							$("#jmid").focus();
						};
					}
					function whenError(e){
						alert("e >>> : " + e.responseText);
					}
				});//endof Ajax on
				
				//비밀번호 체크
				$("#pwCheck").click(function(){
					console.log("pwCheck 함수 진입");
					var pw=$("#jmpw").val();
					var pw_r = $("#jmpw_r").val();
					if(pw==pw_r){
						alert("비밀번호가 같습니다");
						
						$("#jmname").focus();
						return true;
					}else{
						alert("비밀번호가 다릅니다");
						pw.val('');
						pw_r.val('');			
						pw.focus();							
						return false;
					}
				});//endof click
				
				//핸드폰
				
				//이메일
				$("#jmemail2").change(function(){
					$("#jmemail2 option:selected").each(function(){
						if($(this).val()=='1'){//직접입력일경우
							var aa=$("#jmemail1").val();
							$("#jmemail1").val('');//값초기화
							$("#jmemail1").attr("readonly",false);//활성화
						}else{//직접 입력이 아닌경우 
							$("#jmemail1").val($(this).text()); //선택값 입력 
							$("#jmemail1").attr("readonly",true); //비활성화 
						}
					});//endofeach
					
				});
				//endof 이메일change
				
				//우편번호
				$("#zoneBtn").click(function(){
					console.log("jmzipcode >>> : ");
					new daum.Postcode({
						oncomplete: function(data) {
						    $("#jmzipcode").val(data.zonecode); //5자리 새우편번호 사용
						    $("#jmaddr").val(data.roadAddress); //도로명 주소
						   // $("#kmjibun").val(data.jibunAddress); 			
						}
					}).open();
				});//endof우편번호
				
				//I버튼
				$(document).on('click',"#insertBtn",function(){
					$("#memForm").attr({
						 "action":"jdmeMemberInsert.jdme"
						,"method":"POST"
						,"enctype":"multipart/form-data"
					}).submit();
				});//endofon
				
			});//endofReady
		
		</script>
	</head>
	<body>
		<h3 align="center">회원가입</h3>
		<hr>
		<form name="memFrom" id="memForm">
			<table border="1" align="center">
				<tr>
					<td>회원번호</td>
					<td><input type="text" name="jmnum" id="jmnum" placeholder="hidden으로 변경예정" readonly/></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>		
						<input type="text" name="jmid" id="jmid" placeholder="아이디 체크" />
						<input type="button" name="jmidbtn" id="jmidbtn" value="아이디중복확인"  />
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" name="jmpw" id="jmpw" /><br/>	
						<input type="password" name="jmpw_r" id="jmpw_r" placeholder="비밀번호확인" />
						<input type="button" value="비밀번호확인" id="pwCheck"/><br/>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="jmname" id="jmname"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
					  남성 <input type="radio" name="jmgender" value="m" checked />
			                    여성 <input type="radio" name="jmgender" value="f" />
			        </td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="jmbirth" id="jmbirth"/></td>
				</tr>       
				<tr>
					<td>핸드폰</td>
					<td>
						<select name="jmhp" id="jmhp">
				        	<option value="010">010</option>
				        	<option value="011">011</option>
				        	<option value="016">016</option>
				        	<option value="017">017</option>		        	
				         </select>
				         - <input type="text" name="jmhp1" id="jmhp1" size="2" maxlength="4" />
				         - <input type="text" name="jmhp2" id="jmhp2" size="2" maxlength="4" />
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>		
						<input type="text" name="jmemail"  id="jmemail" style="width:100px"/>
						@ <input type="text" name="jmemail1" id="jmemail1" style="width:100px" placeholder="직접입력" />
						<select name="jmemail2" id="jmemail2">
				        	 <option value="1" selected>직접입력</option>
				       		 <option value="naver.com">naver.com</option>	       	   
				      		 <option value="gmail.com">gmail.com</option>
				      		 <option value="daum.net">daum.net</option>	       	   
				         </select>
					</td>
				</tr>
				<tr>
				 	<td>주소</td>
				 	<td>
				 		<input type="text" name="jmzipcode" id="jmzipcode" placeholder="우편번호" style="width:50px" maxlength="6" >
				 		<input type="button" name="zoneBtn" id="zoneBtn" value="우편번호 찾기"><br>	 	
				 		<input type="text" name="jmaddr" id="jmaddr" placeholder="도로명주소" style="width:250px"><br>	 	
				 		<input type="text" name="jmaddrdetail" id="jmaddrdetail" placeholder="도로명주소 상세주소" style="width:250px"><br>	 	
				 	</td>
				</tr>	 
				 <tr>
					<td>사진</td>
					<td> 
						<input type="file" name="jmimage" id="jmimage"  /><br>
				    </td>
				</tr>
				<tr>
					<td colspan="2"> 			
						<button type="button" id="insertBtn">보내기</button>
						<button type="reset">초기화 </button>	
					</td>				
				</tr>
			</table>				 		        		     
		</form>		
	</body>
</html>