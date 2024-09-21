<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ltwebst4/forgot" method="post">
		<h2>Kiểm tra người dùng</h2>
		<c:if test="${alert != null}">
			<h3 class="alert-alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<label>Tên đăng nhập</label><br /> <input type="text" name="username" class="form-control"><br />
					<label>Mật khẩu mới</label><br /> <input type="text" name="password" class="form-control"><br />
					<input type="submit" value="Đổi mật khẩu"> <br />
				</div>
			</label>
		</section>
</body>
</html>