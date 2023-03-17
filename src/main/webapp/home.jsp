<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="img/Logo.png" type="image/x-icon">
<title>PIXEL</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/headers/">

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/sticky-footer/">
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">


<link rel="stylesheet" href="footer.css">
<style type="text/css">
ul.nav a:hover {
	align-items: center;
	background-color: #f7f7f7;
	border-radius: 24px;
	color: #656f79;
	display: inline-flex;
	font-family: inherit;
	font-weight:bold;
	justify-content: center;
	line-height: 40px;
	padding: 0px 16px
}

.container {
	max-width: 95%;
	margin: 20px auto;
}

.container .image-container {
	columns: 4 250px;
	gap: 10px;
}

.container .image-container img {
	margin-bottom: 10px;
	border-radius: 5px;
	width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="headers.jsp"></jsp:include>
	<div class="text-center"
		style="display: flex; align-items: center; justify-content: center; width: 100%; height: 500px; background-image: url(img/web/${web.banner}); background-size: 100%; background-repeat: no-repeat; background-color: rgba(0, 0, 0, 0.85); flex-direction: column; padding-bottom: 20px">
		<h2
			style="margin-bottom: 0; padding: 10px 10px 0 10px; color: #FFFFFF; font-weight: bold; position: relative; bottom: 20px">${web.title1}</h2>
		<p style="color: #FFFFFF;">${web.title2}</p>

		<form style="width: 50%;" action="SearchControl" method="post"
			class="col-12 col-lg-auto mb-3 mb-lg-0 " role="search">
			<div style="display: flex">
				<div
					style="width: 38px; height: 50px; background-color: #fff; border-radius: 20px 0 0 20px">
					<i style="position: relative; top: 13px; left: 2px"
						class="bi bi-search"></i>
				</div>
				<input style="border-radius: 0 20px 20px 0; border: none; height: 50px" value="${txtSearch}"
					name="search" type="search" class="form-control"
					placeholder="Search..." aria-label="Search">
				<div>
					<%-- <select name="idCate" class="form-select"
						aria-label="Default select example"
						style="width: 130px; height: 38px; border-radius: 0px 20px 20px 0px;border: none">
						<option selected>Tất cả hình ảnh</option>
						<c:forEach items="${listC}" var="C">
							<option value="${C.idCategory}">${C.cname}</option>
						</c:forEach>
					</select> --%>
				</div>
			</div>
		</form>
	</div>
	<div style="display: flex; padding: 40px 50px 20px 50px">
		<div style="flex: 5">
			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li
					style="padding: 0 30px 0 30px; font-weight:bold; font-family: inherit;  font-size: 18px"><a
					href="HomeControl" class="nav-link px-2 link-dark">Tất cả</a></li>
				<li
					style="padding: 0 30px 0 30px; font-weight:bold; font-family: inherit; font-size: 18px"><a
					href="trendingControl" class="nav-link px-2 link-dark">Thịnh
						hành</a></li>
				<c:forEach items="${listC}" var="C">
					<li
						style="padding: 0 30px 0 30px;font-weight:bold; font-family: inherit; font-size: 18px;"><a
						href="CategoryControl?cid=${C.idCategory}"
						class="nav-link px-2 link-dark "> ${C.cname}</a></li>
				</c:forEach>

			</ul>
		</div>
	</div>
	<div class="container">

		<div class="image-container">
			<c:forEach items="${listI}" var="I">
				<c:if test="${I.ready==1}">
					<a
						href="ImageDetail?Iid=${I.idImage}&Uid=${I.userID}&Cid=${I.idCategory}">
						<img src="img/dataImg/${I.images}" alt="Lỗi">
					</a>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- JavaScript Bundle with Popper -->
</body>
</html>