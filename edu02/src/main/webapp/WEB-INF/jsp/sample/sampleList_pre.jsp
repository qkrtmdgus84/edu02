<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>sampleList</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet" >
</head>
<body>
<h2>사용자 목록</h2>
<div class="table_list">
<table>
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
                    <td colspan="13">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
         
    </tbody>
</table>
</div>
</body>
</html>
