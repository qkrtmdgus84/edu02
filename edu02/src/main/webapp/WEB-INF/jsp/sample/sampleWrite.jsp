<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>

mode [<%=request.getParameter("mode")%>]

<form id="sampleWrite">
<input type="hidden" id="mode" name="mode" value="result"></input>

	<%if(request.getParameter("mode") != null && request.getParameter("mode").equals("result")) {%>

		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>sampleWrite 처리결과</caption>
			<tbody>
				<c:choose>
					<c:when test="${result }==null || ${result }==''"> 
						<tr><th scope="row">RESULT</th><td>성공</td></tr>
						<tr><td colspan=2 style="text-align:center;"><a href="#list" class="btn_common_red_2" id="list" >확인</a></td></tr>
					</c:when>
					<c:otherwise>
						<tr><th scope="row">RESULT</th><td>실패</td></tr>
						<tr><th scope="row">REASON</th><td>${result }</td>
						</tr>
						<tr><td colspan=2 style="text-align:center;">
							<a href="#list" class="btn_common_red_2" id="list" >확인</a>
							<a href="#back" class="btn_common_red_2" id="back" >뒤로</a>
						</td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

	<%} else {%>

		<table class="board_view">
			<colgroup>
				<col width="20%"  scope="row">
				<col width="*"/>
				<col width="20%"  scope="row">
				<col width="*"/>
			</colgroup>
			<caption>샘플 작성</caption>
			<tbody>
				<tr><th>사용자 아이디</th>
					<td><input type="text" id="userId"         name="userId"         class="wdp_90"></input></td>         <th>업체 코드</th>
					<td><input type="text" id="corpCode"       name="corpCode"       class="wdp_90"></input></td></tr><tr><th>패스워드</th>
					<td><input type="text" id="userPw"         name="userPw"         class="wdp_90"></input></td>         <th>이름</th>
					<td><input type="text" id="userName"       name="userName"       class="wdp_90"></input></td></tr><tr><th>휴대폰 번호</th>
					<td><input type="text" id="userPhone"      name="userPhone"      class="wdp_90"></input></td>         <th>이메일주소</th>
					<td><input type="text" id="userEmail"      name="userEmail"      class="wdp_90"></input></td></tr><tr><th>레벨 (코드)</th>
					<td><input type="text" id="userLevel"      name="userLevel"      class="wdp_90"></input></td>         <th>부서 (코드)</th>
					<td><input type="text" id="userDepartment" name="userDepartment" class="wdp_90"></input></td></tr><tr><th>직급 코드</th>
					<td><input type="text" id="userRole"       name="userRole"       class="wdp_90"></input></td>         <th>상태 (재직,퇴직,휴직)</th>
					<td><input type="text" id="userStatus"     name="userStatus"     class="wdp_90"></input></td></tr><tr><th>프로필 사진파일 이름</th>
					<td><input type="text" id="profileName"    name="profileName"    class="wdp_90"></input></td></tr>
				<!-- <tr>
					<td colspan="2" class="view_text">
						<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
					</td>
				</tr> -->
			</tbody>
		</table>
	
		<input type="button" id="write" class="btn_common_red_2" value="저장">
		<input type="button" id="list" class="btn_common_red_2" value="목록으로">

	<%}%>
</form>

	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<script type="text/javascript">

	$(document).ready(function(){

		$("#list").on("click", function(e){
			e.preventDefault();
			fn_openSampleList();
		});

		$("#write").on("click", function(e){
			e.preventDefault();
			fn_sampleWrite();
		});

		$("#back").on("click", function(e){
			e.preventDefault();
			page_back();
		});
	});




	function fn_openSampleList(){
		location.href="<c:url value='/sample/openSampleList.do' />"
	}

	function fn_sampleWrite(){
		var comSubmit = new ComSubmit("sampleWrite");
		comSubmit.url="<c:url value='/sample/sampleWrite.do' />";
		comSubmit.submit();
	}

	</script>

</body>
</html>
