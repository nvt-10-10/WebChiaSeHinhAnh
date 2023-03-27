<%@page import="org.apache.tomcat.util.net.openssl.OpenSSLUtil"%>
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

	<main class="form-signin w-100 m-auto"
		style="background-color: #f8f9fa; border-radius: 10px">
		<form action="LoginControl" method="post">
					
			<img class="mb-4" src="img/Logo.png" alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Đăng nhập</h1>

			<div class="form-floating">
				<input name="email" type="email" class="form-control"
					id="floatingInput" placeholder="Username"> <label
					for="floatingInput">Email</label>
			</div>
			<div class="form-floating">
				<input name="password" type="password" class="form-control"
					id="floatingPassword" placeholder="Password"> <label
					for="floatingPassword">Password</label>
			</div>
			<div>${mess}</div>
			<div style="display: flex; justify-content: flex-start;"
				class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				nhập</button>
			<p>
				Bạn chưa có tài khoảng? <a href="signup.jsp">Đăng ký</a>
			</p>
		</form>
	</main>
</body>
</html>
