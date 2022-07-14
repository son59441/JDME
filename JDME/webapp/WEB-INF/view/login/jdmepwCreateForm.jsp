<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PW CREATE FORM</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			alert("ready");
			
			$(function(){
			    $('#jmpw').keyup(function(){
			      $('#chkNotice').html('');
			    });

			    $('#jmpw_r').keyup(function(){

			        if($('#jmpw').val() != $('#jmpw_r').val()){
			          $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
			          $('#chkNotice').attr('color', '#f82a2aa3');
			        } else{
			          $('#chkNotice').html('비밀번호 일치함<br><br>');
			          $('#chkNotice').attr('color', '#199894b3');
			        }

			    });
			});
			
			$("#btn").click(function(){
				alert("비밀번호 변경완료");			
				$('#pwCreateForm').attr({
					'action':'pwCreate.jdme',
					'method':'GET'
				}).submit();
				
			})
			
			
			
		});//endofready
		</script>
	</head>
	<body>
		<h3>PW CREATE FORM</h3>
		<hr>
		<form name="pwCreateForm" id="pwCreateForm">
			<table border="1">
				<tr>
					<td>임시비밀번호</td>
					<td><input type="text" name="jmtemppw" id="jmptemppw" style="width:200px;"></td>
				</tr>
				<tr>
					<td>새비밀번호</td>
					<td><input type="text" name="jmpw" id="jmpw" style="width:200px;"></td>
				</tr>
				<tr>
					<td>새비밀번호  확인</td>
					<td><input type="text" name="jmpw_r" id="jmpw_r" style="width:200px;"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<font id="chkNotice" size="2"></font>
					</td>
				</tr>
				<tr>
					<td  colspan="2" align="right">
					<button id="btn" name="btn" style="background-color: yellow;">비밀번호변경</button>
					</td>
				</tr>
			</table> 
		</form>
	</body>
</html>
