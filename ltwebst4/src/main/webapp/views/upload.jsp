<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>
<body>
	<!-- <form method="post" action="${pageContext.request.contextPath }/multiPartServlet" enctype="multipart/form-data">
	<div>Fullname</div>
	<input type="text" name = "fullname" size="100" />
	<input type="submit" value="Upload"/>
	</form>
	
	</br>
	<form method="post" action="${pageContext.request.contextPath }/multiPartServlet" enctype="multipart/form-data">
	<div>Phone</div>
	<input type="text" name = "phone" size="100" />
	<input type="submit" value="Upload"/>
	</form> -->

	</br>
	<div>Servlet Multipart</div>
	<form method="post" action="/ltwebst4/multiPartServlet"
		enctype="multipart/form-data">
		<label>Họ và tên</label> <input type="text" class="form-control"
			name="fullname" id="fullname"> <br /> <label>Phone</label> <input
			type="text" class="form-control" name="phone" id="phone"> <br />
		Choose a file: <input type="file" name="multiPartServlet" /> <input
			type="submit" value="Upload" />
	</form>
	
</body>
</html>