<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ltwebst4/register" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-user"></i>
					</span> <input type="text" placeholder="Email" name="email"
						class="form-control"><br /> <br /> <input type="text"
						placeholder="Tên tài khoản" name="username" class="form-control"><br />
					<br /> <input type="text" placeholder="Họ và tên" name="fullname"
						class="form-control"><br /> <br /> <input type="text"
						placeholder="Mật khẩu" name="password" class="form-control"><br />
					<br /> <input type="text" placeholder="Số điện thoại" name="phone"
						class="form-control"><br /> <br /> <input type="submit"
						value="register">
				</div>
			</label>
		</section>
</body>
</html>