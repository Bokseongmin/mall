<%@ page contentType="text/html; charset=UTF-8" language="java"
	session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/account/up.css">
</head>
<body>
	<header>
		<%@include file="../include/header.jsp"%>
	</header>
	<nav>
		<%@include file="../include/nav.jsp"%>
	</nav>
	<section id="content">
		<form role="form" method="post" autocomplete="off">
			<div class="input_area">
				<label for="userId">아이디</label> <input type="email" id="userId"
					name="userId" placeholder="example@email.com" required="required" />
			</div>

			<div class="input_area">
				<label for="userPass">패스워드</label> <input type="password"
					id="userPass" name="userPass" required="required" />
			</div>

			<div class="input_area">
				<label for="userName">닉네임</label> <input type="text" id="userName"
					name="userName" placeholder="닉네임을 입력해주세요" required="required" />
			</div>

			<div class="input_area">
				<label for="userPhon">연락처</label> <input type="text" id="userPhon"
					name="userPhon" placeholder="연락처를 입력해주세요" required="required" />
			</div>

			<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>

		</form>
	</section>
</body>
</html>