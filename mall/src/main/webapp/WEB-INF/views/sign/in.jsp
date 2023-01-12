<%@ page contentType="text/html; charset=UTF-8" language="java"
	session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/account/in.css">
</head>
<body>
	<header>
		<%@include file="../include/header.jsp"%>
	</header>
	<nav>
		<%@include file="../include/nav.jsp"%>
	</nav>
	<section id="container">
		<div id="container_box">
			<section id="content">
				<form role="form" method="post" autocomplete="off">
					<div class="input_area">
						<label for="userId">아이디</label> <input type="email" id="userId"
							name="userId" required="required" />
					</div>

					<div class="input_area">
						<label for="userPass">패스워드</label> <input type="password"
							id="userPass" name="userPass" required="required" />
					</div>

					<button type="submit" id="signin_btn" name="signin_btn">로그인</button>

					<c:if test="${msg == false}">
						<p style="color: #f00;">로그인에 실패했습니다.</p>
					</c:if>
				</form>
			</section>
		</div>
	</section>
</body>
</html>