<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.104.2">
<link rel="icon" href="img/Logo.png" type="image/x-icon">
<title>PIXEL</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center" style="background-color: #ffffff">
	<form action="SigupControl" method="post" class="row g-3 m-auto"
		style="width: 30%; padding: 15px; z-index: 2; background-color: #f8f9fa; border-radius: 10px">
		<a style="display: flex; justify-content: flex-end; margin: 0"
			href="#"><i class="bi bi-x-lg"></i></a>
		<h1 class="h3 mb-3 fw-normal">Đăng ký</h1>

		<div class="col-12">
			<input name="gmail" type="email" class="form-control"
				id="inputEmail4" placeholder="Email" required>
		</div>
		<div class="col-md-6">
			<input name="password" type="password" class="form-control"
				id="inputPassword4" placeholder="Mật khẩu" required>
		</div>
		<div class="col-md-6">
			<input name="repeatpassword" type="password" class="form-control"
				id="inputPassword4" placeholder="Xác nhận" required>
		</div>
		<div class="col-12">
			<input name="firstName" type="text" class="form-control"
				id="inputAddress" placeholder="FirstName" required>
		</div>
		<div class="col-12">
			<input name="lastName" type="text" class="form-control"
				id="inputAddress" placeholder="LastName" required>
		</div>
		<div class="col-12">
			<select name="gender" class="form-select"
				aria-label="Default select example">
				<option selected>Giới tính</option>
				<option value="Nam">Nam</option>
				<option value="Nữ">Nữ</option>
			</select>
		</div>
		${mess}
		<div class="col-12">
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				ký</button>
		</div>
	</form>
</body>
</html>
