<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>

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

    <%@ include file="/WEB-INF/include/include-body.jspf" %>

	<script type="text/javascript">
	$(document).ready(function(){

		$("#list").on("click", function(e){
			e.preventDefault();
			fn_openSampleList();
		});

		$("#back").on("click", function(e){
			e.preventDefault();
			page_back();
		});

	});

	function fn_openSampleList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openSampleList.do' />");
		comSubmit.submit();
	}

	</script>

</body>
</html>
