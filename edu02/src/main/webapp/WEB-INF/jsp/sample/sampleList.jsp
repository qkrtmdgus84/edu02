<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>sampleList</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet" >
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="<c:url value='/resources/js/common.js'/>" charset="utf-8"></script>
</head>
<body>
<%
String userId         = request.getParameter("userId")        ;
String userName       = request.getParameter("userName")      ;
String userPhone      = request.getParameter("userPhone")     ;
String userEmail      = request.getParameter("userEmail")     ;
String corpCode       = request.getParameter("corpCode")      ;
String userLevel      = request.getParameter("userLevel")     ;
String userDepartment = request.getParameter("userDepartment");
String corpName       = request.getParameter("corpName")      ;
String corpLevel      = request.getParameter("corpLevel")     ;
String profileName    = request.getParameter("profileName")   ;
String departmentName = request.getParameter("departmentName");
String userRankname   = request.getParameter("userRankname")  ;
%>

<!-- <form action="openSampleList.do" method="post"> -->
<form>
<div class="common_table_summit">
<table>
	<thead>
	</thead>
	<tbody>
		<tr><th>userId         :</th><th class="wd110"><input class="wd100" name="userId"         value="${userId        }"/></th><%-- 
			<th>userName       :</th><th class="wd110"><input class="wd100" name="userName"       value="${userName      }"/></th> --%>
			<th>userPhone      :</th><th class="wd110"><input class="wd100" name="userPhone"      value="${userPhone     }"/></th>
			<th>userEmail      :</th><th class="wd110"><input class="wd100" name="userEmail"      value="${userEmail     }"/></th>
			<th>
				<input type="submit" class="btn_common_red_2" value="검색">
				<input type="button" id="openWrite" class="btn_common_red_2" value="글쓰기">
			</th>
		</tr>
		<%-- 
		<tr><th>corpCode       :</th><th class="wd110"><input class="wd100" name="corpCode"       value="${corpCode      }"/></th>
			<th>userLevel      :</th><th class="wd110"><input class="wd100" name="userLevel"      value="${userLevel     }"/></th>
			<th>userDepartment :</th><th class="wd110"><input class="wd100" name="userDepartment" value="${userDepartment}"/></th>
			<th>corpName       :</th><th class="wd110"><input class="wd100" name="corpName"       value="${corpName      }"/></th></tr>
		<tr><th>corpLevel      :</th><th class="wd110"><input class="wd100" name="corpLevel"      value="${corpLevel     }"/></th>
			<th>profileName    :</th><th class="wd110"><input class="wd100" name="profileName"    value="${profileName   }"/></th>
			<th>departmentName :</th><th class="wd110"><input class="wd100" name="departmentName" value="${departmentName}"/></th>
			<th>userRankname   :</th><th class="wd110"><input class="wd100" name="userRankname"   value="${userRankname  }"/></th></tr> --%>
	</tbody>
</table>
</div>
</form>

<table><tr><td>
<h2>샘플 목록</h2>
<%if(  (request.getParameter("userId")         != null && request.getParameter("userId")         != "")
	|| (request.getParameter("userName")       != null && request.getParameter("userName")       != "")
	|| (request.getParameter("userPhone")      != null && request.getParameter("userPhone")      != "")
	|| (request.getParameter("userEmail")      != null && request.getParameter("userEmail")      != "")
	|| (request.getParameter("corpCode")       != null && request.getParameter("corpCode")       != "")
	|| (request.getParameter("userLevel")      != null && request.getParameter("userLevel")      != "")
	|| (request.getParameter("userDepartment") != null && request.getParameter("userDepartment") != "")
	|| (request.getParameter("corpName")       != null && request.getParameter("corpName")       != "")
	|| (request.getParameter("corpLevel")      != null && request.getParameter("corpLevel")      != "")
	|| (request.getParameter("profileName")    != null && request.getParameter("profileName")    != "")
	|| (request.getParameter("departmentName") != null && request.getParameter("departmentName") != "")
	|| (request.getParameter("userRankname")   != null && request.getParameter("userRankname")   != "")
	) {%>
			</td><td> - 조회 조건(
			<%if(request.getParameter("userId")         != null && request.getParameter("userId")         != ""){%>userId        :<%= request.getParameter("userId")        %><%}%><%-- 
			<%if(request.getParameter("userName")       != null && request.getParameter("userName")       != ""){%>userName      :<%= request.getParameter("userName")      %><%}%> --%>
			<%if(request.getParameter("userPhone")      != null && request.getParameter("userPhone")      != ""){%>userPhone     :<%= request.getParameter("userPhone")     %><%}%>
			<%if(request.getParameter("userEmail")      != null && request.getParameter("userEmail")      != ""){%>userEmail     :<%= request.getParameter("userEmail")     %><%}%><%-- 
			<%if(request.getParameter("corpCode")       != null && request.getParameter("corpCode")       != ""){%>corpCode      :<%= request.getParameter("corpCode")      %><%}%>
			<%if(request.getParameter("userLevel")      != null && request.getParameter("userLevel")      != ""){%>userLevel     :<%= request.getParameter("userLevel")     %><%}%>
			<%if(request.getParameter("userDepartment") != null && request.getParameter("userDepartment") != ""){%>userDepartment:<%= request.getParameter("userDepartment")%><%}%>
			<%if(request.getParameter("corpName")       != null && request.getParameter("corpName")       != ""){%>corpName      :<%= request.getParameter("corpName")      %><%}%>
			<%if(request.getParameter("corpLevel")      != null && request.getParameter("corpLevel")      != ""){%>corpLevel     :<%= request.getParameter("corpLevel")     %><%}%>
			<%if(request.getParameter("profileName")    != null && request.getParameter("profileName")    != ""){%>profileName   :<%= request.getParameter("profileName")   %><%}%>
			<%if(request.getParameter("departmentName") != null && request.getParameter("departmentName") != ""){%>departmentName:<%= request.getParameter("departmentName")%><%}%>
			<%if(request.getParameter("userRankname")   != null && request.getParameter("userRankname")   != ""){%>userRankname  :<%= request.getParameter("userRankname")  %><%}%> --%>
			)<%}%>
</td></tr></table>

<table class="table_list">
	<colgroup>
		<col width="5%" style="border:1px"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">사용자ID</th>
			<th scope="col">사용자이름</th>
			<th scope="col">휴대폰번호</th>
			<th scope="col">이메일주소</th><!-- 
			<th scope="col">업체 코드</th>
			<th scope="col">사용자등급</th>
			<th scope="col">부서</th>
			<th scope="col">업체등급</th> -->
			<th scope="col">업체명</th>
			<th scope="col">부서명</th>
			<th scope="col">사용자등급명</th>
			<th scope="col">프로필 사진파일 이름</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<c:forEach items="${list }" var="row">
					<tr>
						<td>${row.userId        }</td>
						<td>${row.userName      }</td>
						<td>${row.userPhone     }</td>
						<td>${row.userEmail     }</td><%-- 
						<td>${row.corpCode      }</td>
						<td>${row.userLevel     }</td>
						<td>${row.userDepartment}</td>
						<td>${row.corpLevel     }</td> --%>
						<td>${row.corpName      }</td>
						<td>${row.departmentName}</td>
						<td>${row.userRankname  }</td>
						<td>${row.profileName   }</td>
					</tr>
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

	<script type="text/javascript">
	$(document).ready(function(){

		$("#openWrite").on("click", function(e){
			e.preventDefault();
			fn_openSampleWrite();
		});

	});

	function fn_openSampleWrite(){
		location.href="<c:url value='/sample/sampleWrite.do' />"
	}

	</script>


</body>
</html>
