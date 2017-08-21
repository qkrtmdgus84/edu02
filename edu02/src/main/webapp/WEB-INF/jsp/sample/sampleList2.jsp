<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>sampleList</title>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/include/include-header.jspf"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	$(document).ready(function() {
		$("#load").on("click", function(e) {
			fn_selectBoardList(1);
		});
		$("#openWrite").on("click", function(e) {
			e.preventDefault();
			fn_openSampleWrite();
		});
		/* 자동완성 */
		$("#choose").on("change", function() {
			$("#search").val('');
		});

		$("#search").on("focus", function() {
			var id = $(this).attr("id");
			var select = $("#choose option:selected").val();
			switch (select) {
			case '001':
				$("#search").attr("name", "userId");
				break;
			case '002':
				$("#search").attr("name", "userPhone");
				break;
			case '003':
				$("#search").attr("name", "userEmail");
				break;
			}
			autocomplete(id, select);
		});

		/* 체크박스 선택에 따른 색상 변경 */
		$("#allCheck").click(function() {
			var index = (this).index();
			//만약 전체 선택 체크박스가 체크된상태일경우
			if ($("#allCheck").prop("checked")) {
				//해당화면에 전체 checkbox들을 체크해준다
				$("input[name=box]").prop("checked", true);
				$("[class^=class]").css("background-color", "silver");
				// 전체선택 체크박스가 해제된 경우
			} else {
				//해당화면에 모든 checkbox들의 체크를해제시킨다.
				$("input[name=box]").prop("checked", false);
				$("[class^=class]").css("background-color", "white");
			}
		});
		$("input[type=checkbox]").click(function() {
			if ($(this).prop("checked")) {
				$(this).parents("tr").css("background-color", "silver");
			} else {
				$(this).parents("tr").css("background-color", "white");
			}
		});

		$("input[name=modifyBtn]").on("click", function() {
			var index = $("input[name=modifyBtn]").index(this);
			var status = $("#hidden" + index).css("display");
			if (status == "none") {
				$("#hidden" + index).css("display", "");
			} else {
				$("#hidden" + index).css("display", "none");
			}
			$.ajax({
				type : "get",
				data : "userId=" + $("#hidden_userId" + index).val(),
				url : "openSampleOne.do",
				success : function(data) { //성공시 이 함수를 호출한다.
					$("#modifyForm" + index).html(data).slideDown("slow");
				}
			});
		});

		$("#del_btn").on("click", function(e) {
			e.preventDefault();
			if ($("input[name=box]:checked").length == 0) {
				alert("선택된 데이터가 없습니다.");
			} else {
				$("#deleteForm").submit();
			}
		});

/* 		$("#my-button").bind('click', function(e) {
			// Prevents the default action to be  triggered. 
			e.preventDefault();
			// Triggering bPopup when click event is fired
			msg("안녕하세요")
		}); */
		
 		$("#userRank").on("change", function(){
			$.ajax({
				type	:"post",
				url		:"userRank.do",
				data	:"value="+$(this).val(),
				success : function(data) {
					var str;
					$.each(data, function(key,row){                                                
					str+='<tr>                                                    '
					+'	<td><input type="checkbox" name="box" value="'+ row.userId  +'" /></td>'
					+'	<td>'+ row.userId		 +'</td>                                              '
					+'	<td>'+ row.userName      +'</td>                                              '
					+'	<td>'+ row.userPhone     +'</td>                                              '
					+'	<td>'+ row.userEmail     +'</td>                                              '
					+'	<td>'+ row.corpName      +'</td>                                              '
					+'	<td>'+ row.departmentName+'</td>                                              '
					+'	<td>'+ row.userRankname  +'</td>                                              '
					+'	<td>'+ row.profileName   +'</td>                                              '
					+'</tr>                                                                          '
					});
					
					$("#innerBody").html(str);		
				}				
			});
		});
	});

	/*         $(document).ready(function(){
	 fn_selectBoardList(1);
	 }); */

	/*         function fn_openBoardWrite(){
	 var comSubmit = new ComSubmit();
	 comSubmit.setUrl("<c:url value='/sample/openBoardWrite.do' />");
	 comSubmit.submit();
	 } */

	/*         function fn_openBoardDetail(obj){
	 var comSubmit = new ComSubmit();
	 comSubmit.setUrl("<c:url value='/sample/openBoardDetail.do' />");
	 comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
	 comSubmit.submit();
	 } */

	function fn_selectBoardList(pageNo) {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/sample/openSampleList.do' />");
		comAjax.setCallback("fn_selectBoardListCallback");
		comAjax.addParam("PAGE_INDEX", pageNo);
		comAjax.addParam("PAGE_ROW", 20);
		comAjax.ajax();
	}

	function fn_selectBoardListCallback(data) {
		var total = data.TOTAL;
		var body = $("#body");
		body.empty();
		if (total == 0) {
			var str = '<table class="table">                                  '
					+ '	<colgroup>                                            '
					+ '		<col width="5%" style="border: 1px" />            '
					+ '	</colgroup>                                           '
					+ '		<tr class="Black_title">                          '
					+ '			<th scope="col">ListID</th>                   '
					+ '			<th scope="col">SENDER</th>				      '
					+ '			<th scope="col">REC_Name</th>                 '
					+ '			<th scope="col">RECEIVED</th>                 '
					+ '			<th scope="col">INST_DATE</th>                '
					+ '		</tr>                                             '
					+ '	<tr>                                                  '
					+ '		<td colspan="4">조회된 결과가 없습니다.</td>				  '
					+ '	</tr>                                                 '
					+ '</table>                                               '
			body.append(str);
		} else {
			var params = {
				divId : "page",
				pageIndex : "PAGE_INDEX",
				totalCount : total,
				eventName : "fn_selectBoardList"
			};
			gfn_renderPaging(params);

			var str = "";
			str += '<table class="table">                                     '
					+ '	<colgroup>                                            '
					+ '		<col width="5%" style="border: 1px" />            '
					+ '	</colgroup>                                           '
					+ '		<tr class="Black_title">                          '
					+ '			<th scope="col">ListID</th>                   '
					+ '			<th scope="col">SENDER</th>				      '
					+ '			<th scope="col">REC_Name</th>                 '
					+ '			<th scope="col">RECEIVED</th>                 '
					+ '			<th scope="col">INST_DATE</th>                '
					+ '		</tr>                                             '
					+ '	<tbody>												  '
			$.each(data.list, function(key, value) {
				str += '<tr>                                                '
						+ '<td>' + value.LISTID + '</td>                    '
						+ '<td>' + value.SENDER + '</td>                    '
						+ '<td>' + value.RECNAME + '</td>                   '
						+ '<td>' + value.RECEIVED + '</td>                  '
						+ '<td>' + value.INSTDATE + '</td>                  '
						+ '</tr>                                            '
			});
			str += '</tbody>                                                '
					+ '</table>                                                '
			body.append(str);
		}
	}
</script>
</head>
<body>
	<%
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String corpCode = request.getParameter("corpCode");
		String userLevel = request.getParameter("userLevel");
		String userDepartment = request.getParameter("userDepartment");
		String corpName = request.getParameter("corpName");
		String corpLevel = request.getParameter("corpLevel");
		String profileName = request.getParameter("profileName");
		String departmentName = request.getParameter("departmentName");
		String userRankname = request.getParameter("userRankname");
	%>

	<!-- <form action="openSampleList.do" method="post"> -->
	<form>
		<div class="common_table_summit">
			<table>
				<thead>

				</thead>
				<tbody>
					<tr>
						<th><strong style="color: red">${userId }</strong> 님 환영합니다요~~~~ <a
							href=logout.do>로그아웃</a></th>
						<th style="text-align: right"><select id="choose"
							style="width: 300pxl; height: 25px;">
								<option value="001">사용자ID</option>
								<option value="002">핸드폰번호</option>
								<option value="003">이메일</option>
						</select> <input class="wd100" id="search" name="search" value="" /></th>
						<th style="width: 300px;"><input type="submit"
							class="btn_common_red_2" value="검색"> <input type="button"
							id="openWrite" class="btn_common_red_2" value="글쓰기"> <input
							type="button" id="load" class="btn_common_red_2" value="블랙리스트">
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	<form action="deleteUsers.do" method="post" id="deleteForm">
		<table>
			<tr>
				<td>
					<h2>
						샘플 목록
						<button id="del_btn" type="submit"
							class="btn btn-default glyphicon glyphicon-trash"></button>
					</h2> <%
 	if ((request.getParameter("userId") != null && request.getParameter("userId") != "")
 			|| (request.getParameter("userName") != null && request.getParameter("userName") != "")
 			|| (request.getParameter("userPhone") != null && request.getParameter("userPhone") != "")
 			|| (request.getParameter("userEmail") != null && request.getParameter("userEmail") != "")
 			|| (request.getParameter("corpCode") != null && request.getParameter("corpCode") != "")
 			|| (request.getParameter("userLevel") != null && request.getParameter("userLevel") != "")
 			|| (request.getParameter("userDepartment") != null && request.getParameter("userDepartment") != "")
 			|| (request.getParameter("corpName") != null && request.getParameter("corpName") != "")
 			|| (request.getParameter("corpLevel") != null && request.getParameter("corpLevel") != "")
 			|| (request.getParameter("profileName") != null && request.getParameter("profileName") != "")
 			|| (request.getParameter("departmentName") != null && request.getParameter("departmentName") != "")
 			|| (request.getParameter("userRankname") != null && request.getParameter("userRankname") != "")) {
 %>
				</td>
				<td>- 조회 조건( <%
					if (request.getParameter("userId") != null && request.getParameter("userId") != "") {
				%>userId:<%=request.getParameter("userId")%><%	} %>
				<%	if (request.getParameter("userPhone") != null && request.getParameter("userPhone") != "") {
 				%>userPhone :<%=request.getParameter("userPhone")%> <%	} %> 
 				<% 	if (request.getParameter("userEmail") != null && request.getParameter("userEmail") != "") {
 				%>userEmail:<%=request.getParameter("userEmail")%> <%} %> )<%} %>
				</td>
			</tr>
		</table>
		<div id="page" align="center"></div>
		<div id="body">
			<table class="table">
				<colgroup>
					<col width="5%" style="border: 1px" />
				</colgroup>
				<thead>
					<tr id="List_title">
						<th style="text-align: center"><input type="checkbox"
							id="allCheck" /></th>
						<th scope="col">사용자ID</th>
						<th scope="col">사용자이름</th>
						<th scope="col">휴대폰번호</th>
						<th scope="col">이메일주소</th>
						<th scope="col">업체명</th>
						<th scope="col">부서명</th>
						<th scope="col">
							<select id="userRank">
								<option selected value="all">사용자등급명</option>
								<option value="1">대리</option>
								<option value="2">차장</option>
							</select>						
						</th>
						<th scope="col">프로필 사진파일 이름</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody id="innerBody">
					<c:choose>
						<c:when test="${fn:length(list) > 0}">
							<c:forEach items="${list }" var="row" varStatus="st">
								<tr id="color${st.index }">
									<td><input type="checkbox" name="box" value="${row.userId		   }" /></td>
									<td>${row.userId		   }</td>
									<td>${row.userName      }</td>
									<td>${row.userPhone     }</td>
									<td>${row.userEmail     }</td>
									<td>${row.corpName      }</td>
									<td>${row.departmentName}</td>
									<td>${row.userRankname  }</td>
									<td>${row.profileName   }</td>
								</tr>
								<!--  -->
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="8">조회된 결과가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<input type="hidden" id="PAGE_INDEX" name="PAGE_INDEX" />
	</form>
	<div id='popup'></div>
</body>
</html>
