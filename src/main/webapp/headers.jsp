<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- header -->
		<header class="border-bottom" style="padding: 10px 60px 10px 80px">
			<div>

				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<div>						<a style="padding:0 20px 0 20px; text-decoration: none; color: black; font-family:monospace; font-weight: bold; font-size: 30px"
							href="HomeControl">PIXEl</a>
					</div>
					
					<ul
						class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
						<li style="padding-left: 15px;">
					</ul>
				  	<h6 style="padding:0 15px 0 30px; font-weight: bold; margin-top: 17px">${sessionScope.acc.lastName} ${sessionScope.acc.firstName}</h6>
					<c:if test="${sessionScope.acc != null}">
						<div class="dropdown text-end">
							<a href="#"
								class="d-block link-dark text-decoration-none dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false">
								<img
								src="img/userimage/${sessionScope.acc.uImages}" alt="" width="32"
								height="32" class="rounded-circle">
							</a>
							<ul class="dropdown-menu text-small">
								<li><a class="dropdown-item" href="AboutControl?Uid=${sessionScope.acc.userID}">Trang cá nhân</a></li>
								<li><a class="dropdown-item" href="LogoutControl">Đăng xuất</a></li>
							</ul>
						</div>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<a href="Login.jsp"
							style="padding-left: 30px; size: 20px; text-decoration: none; color: black;">Đăng nhập</a>
					</c:if>
					<div style="position: relative; left: 100px;"></div>
				</div>
			</div>
		</header>
		<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
		<!-- end header -->