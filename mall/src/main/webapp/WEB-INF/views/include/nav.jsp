<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:if test="${account==null}">
		<li><a href="/sign/in">로그인</a></li>
		<li><a href="/sign/up">회원가입</a></li>
	</c:if>
	<c:if test="${account!=null}">
		<li><a>${account.userName}님 환영합니다.</a></li>
		<li><a href="/sign/out">로그아웃</a></li>
	</c:if>
</ul>