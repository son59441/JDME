<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="jdme.board.com.vo.JDMEBoardComVO" %> 
<%@ page import="jdme.board.reply.vo.JDMEBoardReplyVO" %>    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<% request.setCharacterEncoding("UTF-8");%>  
    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			// 댓글 길이 제한 2000byte로 주기
			$("#jrcontent").keyup(function(){
				cut_2000(this);
			});
			
			// 댓글 전체 불러오기
			selectAll();
			
			// 댓글 등록하기
			$(document).on('click','#insertBtn',function(){
				console.log("댓글 등록 버튼 클릭");
				
				let insertURL = "JDMEBoardReplyInsert.jdme";
				let method = "POST";
				let dataparam = {
						jbnum :     $("#jbnum").val(),
						jrid :      $("#jrid").val(),
						jrcontent : $("#jrcontent").val(),
				};
				dataParam = $("#replyForm").serialize();
				console.log("dataParam --> : " + dataParam);
				
				$.ajax({
					url : insertURL,
					type : method,
					data : dataParam,
					success : whenSuccess,
					error : whenError
				}); // end of ajax
				
				function whenSuccess(resData){
					
					if("GOOD" == resData){
						// 입력 데이터 초기화 함수 호출
						replyFormData();
						selectAll();
					}
				}
				function whenError(e){
					alert("e --> : " + e.responseText);
				}
				
			}); // end of 댓글 등록하기
			
			
			// 댓글 삭제
			$(document).on('click','.deleteBtn',function(){
				console.log("deleteBtn 클릭 ");
				
				var jrnumV = $(this).parents("li").attr("dataNum");
				alert("jrnumV --> : " + jrnumV);
				
				var target = $(this).parents(".jrbmemoItem");	
				console.log("target --> : " + target);
				
				let deleteURL = "JDEMBoardReplyDelete.jdme";
				let method = "POST";
				let dataParam = {
						jrnum : $("#jrnum").val(jrnumV),
				};
				dataParam = $("#replyForm").serialize();
				console.log("dataParam --> : " + dataParam);
				
				$.ajax({
					url : deleteURL,
					type: method,
					data : dataParam,
					success : whenSuccess,
					error : whenError
				});
				
				function whenSuccess(resData){
					console.log("resData --> : " + resData);
					if("GOOD" == resData){
						alert("댓글이 삭제 되었습니다.");
						target.remove();
					}
				
				}
				function whenError(e){
					console.log("e --> : " + e.responseText);
				}
				
			}); // end of 댓글 삭제하기
			
		}); // end of ready
	
		// 게시글 번호로 댓글 전체 조회하기
		function selectAll(){
			console.log("댓글 전체 조회 하기");
			
			let selectAllURL = "JDMEBoardReplySelectAll.jdme";
			let method = "POST";
			let dataParam = {
					jrnum : $("#jrnum").val(),
			};
			dataParam = $("#replyForm").serialize();
			console.log("dataParam --> : " + dataParam);
			
			$.ajax({
				url: selectAllURL,
				type: method,
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){
				console.log("resData --> : " + resData);
				console.log("whenSuccess JDMEBoardReplySelectAll resData --> : " + resData)
			
				if(isEmpty(resData)){
					return false;
				}
				
				let v = resData.split("&");
				for(let i = 0; i < v.length; i++){
					console.log(v[i]);
					let vv = v[i].split(",");
					let j = 0
					for(; j < vv.length-1; j++){
						console.log("vv[0] --> : " + vv[0]);
						console.log("vv[1] --> : " + vv[1]);
						console.log("vv[2] --> : " + vv[2]);
						console.log("vv[3] --> : " + vv[3]);
					}
					addNewItem(vv[0], vv[1], vv[2], vv[3]);
				}
			
			}
			function whenError(e){
				console.log("e --> : " + e.responseText);
			}	
			
		} // end of selectAll()
	
	
		// 새로운 글 화면에 추가하기 
		function addNewItem(num, writer, content, datetime){
			
			//데이터 체크
			if(isEmpty(num)) return false;
			
			// 새로운 글이 추가 될 li 태그
			var newLi = $("<li>");
			newLi.attr("dataNum",num);
			newLi.addClass("jrbmemoItem");
	
			// 작성자 정보가 지정될 <p> 태그 
			var writerP = $("<p>");
			writerP.addClass("writer");
			
			// 작성자 정보의 이름 
			var nameSpan = $("<span>");
			nameSpan.addClass("name");
			nameSpan.html(decodeURIComponent(writer) + "님");
			
			// 작성일시 
			var dateSpan = $("<span>");
			dateSpan.html(" / " + datetime + " ");
			
			// 삭제 버튼 
			var delInput = $("<input>");
			delInput.attr({"type":"button", "value":"삭제하기","style":"width:100px;"});
			delInput.addClass("deleteBtn");
			
			// 내용
			var contentP = $("<p>");
			contentP.html(decodeURIComponent(content));
			
			// 조립하기
			writerP.append(nameSpan).append(dateSpan).append(delInput);
			newLi.append(writerP).append(contentP);
			$("#replylist").append(newLi);		
			
		} // end of addNewItem
		
		// 댓글 길이 체크, 한글 포함 문자열 길이
		function getTextLength(s){
			var len = 0;
			for(var i=0; i < s.length; i++){
				if(escape(s.charAt(i)).length == 6){
					len++;
				}
				len++;
			}
			return len;
			
		} // end of getTextLength
		
		function cut_2000(obj){
			var t = $(obj).val();
			var l = t.length;
			while(getTextLength(t) > 2000){
				l--;
				t = t.substring(0, 1);
			}
			$(obj).val(t);
			$('.bytes').text(getTextLength(t));
		
		} // end of cut_2000 
		
		// 댓글 등록 후 입력 창 초기화
		function replyFormData(){
			$("#jrid").val("");
			$("#jrcontent").val("");
		}
		
		// 데이터 체크
		function isEmpty(val){
			if(typeof val=="undefined" || val==null || val==""){
				return true;
			}else{
				return false;
			}
		}
		
	
	</script>
	</head>
	<body>
		<h3>댓글</h3>
		<hr>
		<%
			Logger logger = LogManager.getLogger(this.getClass());
			logger.info("JDMEBoardReplyInsertForm 페이지 진입");
			
			String jbnum = request.getParameter("jbnum");
			logger.info("ReplyForm jbnum --> : " + jbnum);
		%>
		<div id="replydiv">
			<form name="replyForm" id="replyForm">
				<table>
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" name="jrid" id="jrid" style="width:300px;"/>
							<input type="hidden" name="jbnum" id="jbnum" value="<%=jbnum%>">
							<input type="hidden" name="jrnum" id="jrnum">
							<input type="button" value="저장하기" id="insertBtn"style="width:100px;">
						</td>
					</tr>
					<tr>
						<td>댓글 내용</td>
						<td>
							<textarea name="jrcontent" id="jrcontent" rows="5" cols="50" style="resize: none"></textarea>
							<div><span class="bytes">0</span>bytes</div>
						</td>
					</tr>
				</table>
				<hr>
				<ul name="replylist" id="replylist">
					<!-- 여기에 동적 생성 요소가 들어온다. -->
				</ul>
			</form>
		</div>
	</body>
</html>