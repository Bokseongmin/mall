<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:if test="${account==null}">
		<li><a href="/sign/in">로그인</a></li>
		<li><a href="/sign/up">회원가입</a></li>
	</c:if>
	<c:if test="${account!=null}">
		<c:if test="${account.verify==9}">
			<li><a href="/admin/index">관리자 화면</a></li>
		</c:if>
		<li><a>${account.userName}님 환영합니다.</a></li>
		<li><a href="/shop/cartList">카트 리스트</a></li>
		<li><a href="/shop/orderList">주문 리스트</a></li>
		<li><a href="/sign/out">로그아웃</a></li>
	</c:if>
</ul>