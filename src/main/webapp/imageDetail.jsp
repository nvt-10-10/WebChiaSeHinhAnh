<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<link rel="stylesheet" href="assets/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/headers/">
<link rel="stylesheet" href="css/Imagedetail.css">
<link rel="stylesheet" href="css/formcomment.css">
<link rel="stylesheet" href="css/modal.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
@media screen and(max-width:660px) {
	.right-column {
		width: 100%;
	}
}
</style>
<link rel="icon" href="img/Logo.png" type="image/x-icon">
<title>PIXEL</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						var originalForm = '<form action="UpdateCommentCotroller?Iid=${detail.idImage}&Uid=${Ac.userID}&Cid=${detail.idCategory}" method="post">'
								+ '<input type="hidden" name="id_commennt" id="id_commennt" value="">'
								+ '<textarea name="comment" id="comment" placeholder="comment" required></textarea>'
								+ '<button class="comment-submit" id="huy" type="submit">Gửi</button>'
								+ '<a class="comment-submit" style="background-color: aliceblue ; color: black; margin-left: 5px;" id="huy" href="#">Hủy</a>'
								+ '</form>';
						var form2 = '<form action="InsertCommentControl?Iid=${detail.idImage}&Uid=${Ac.userID}&Cid=${detail.idCategory}" method="post"> '
								+ '<textarea name="comment" placeholder="comment" required></textarea>'
								+ '<button class="comment-submit" type="submit">Comment</button>'
								+ '</form>';

						var commentForm = document.getElementById("comment1");

						var arr_edit = document
								.querySelectorAll(".edit-comment");
						for (var i = 0; i < arr_edit.length; i++) {
							arr_edit[i].addEventListener("click", function(e) {
								console.log("123");
								e.preventDefault();
								var commentId = $(this).data("comment-id");
								var commentText = $(this).data("comment-text");
								commentForm.innerHTML = originalForm;
								$("#id_commennt").val(commentId);
								$("#comment").val(commentText);
							});
						}

						$(document).on("click", "a#huy", function(e) {
							console.log("123");
							e.preventDefault();
							commentForm.innerHTML = form2;
						});

					});
</script>
</head>
<body>


	<jsp:include page="headers.jsp"></jsp:include>
	<main
		style="max-width: 1200px; margin: 0 auto; padding: 15px; display: flex; margin-top: 20px">
		<!-- Left Column / Headphones Image -->

		<div class="left-column">
			<div class="text-center">
				<img style="border-radius: 5px; max-width: 100%; max-height: 100vh;"
					src="img/dataImg/${detail.images}" alt="">
			</div>
			<div class="comment-session">
				<c:forEach items="${listCM}" var="listCM">
					<div class="post-comment">
						<div class="list">
							<div class="user">
								<div class="user-image">
									<img src="img/userimage/${listCM.uImages}" alt="">
								</div>
								<div class="user-meta">
									<div class="name">${listCM.lastName}${listCM.firstName}</div>
									<div class="day">${listCM.commentDay}</div>
								</div>
								<div style="display: flex; margin-left: 150px">
									<c:if test="${listCM.userID == sessionScope.acc.userID}">
										<a class="bi bi-pencil-fill edit-comment"
											style="padding: 0 10px 0 0; text-decoration: none; font-size: 13px;"
											data-comment-id="${listCM.idComment}"
											data-comment-text="${listCM.comment}" href="#"></a>
										<a class="bi bi-trash-fill"
											style="padding: 0 10px 0 0; text-decoration: none; font-size: 13px; color: red"
											href="DeleteCommentControl?CMid=${listCM.idComment}&Iid=${detail.idImage}&Uid=${Ac.userID}&Cid=${detail.idCategory}"></a>

									</c:if>
								</div>
							</div>
							<div class="comment-post">${listCM.comment}</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${sessionScope.acc != null}">
					<div class="comment-box">
						<div class="user">
							<div class="image">
								<img src="img/userimage/${sessionScope.acc.uImages}" alt="">
							</div>
							<div class="name">${sessionScope.acc.lastName}
								${sessionScope.acc.firstName}</div>
						</div>
						<div id="comment1">
							<form
								action="InsertCommentControl?Iid=${detail.idImage}&Uid=${Ac.userID}&Cid=${detail.idCategory}"
								method="post">
								<textarea name="comment" placeholder="comment" required></textarea>
								<button class="comment-submit" type="submit">Comment</button>
							</form>
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.acc == null}">
					<%
					String idImage = request.getParameter("Iid");
					String Uid = request.getParameter("Uid");
					String Cid = request.getParameter("Cid");

					HttpSession session1 = request.getSession();
					session1.setAttribute("Iid", idImage);
					session1.setAttribute("Uid", Uid);
					session1.setAttribute("Cid", Cid);
					%>
					<div class="comment-box">
						<a href="Login.jsp">Đăng nhập để bình luận</a>
					</div>
				</c:if>
			</div>
		</div>

		<!-- Right Column -->
		<div class="right-column"
			style="width: 30%; margin-top: 0px; padding: 0 10px 10px 30px">
			<div class="product-description"
				style="background-color: #f8f9fa; width: 100%; height: 150px; border-radius: 5px;">

				<div
					style="display: flex; align-self: center; padding: 10px 0 10px 10px">
					<c:if test="${Ac.uImages != null}">
						<img class="rounded-circle" src="img/userimage/${Ac.uImages}"
							width="40" height="40">
					</c:if>
					<c:if test="${Ac.uImages == null}">
						<img class="rounded-circle"
							src="https://cdn-icons-png.flaticon.com/512/1946/1946429.png"
							width="40" height="40">
					</c:if>
					<a
						style="text-decoration: none; font-size: 20px; color: black; padding: 5px 10px 0 10px"
						href="AuthorControl?Uid=${Ac.userID}">${Ac.lastName}
						${Ac.firstName}</a>
				</div>
				<div style="padding-left: 15px">
					<p>
						<i class="bi bi-envelope-fill"></i> ${Ac.gmail}
					</p>
					<p>
						<i class="bi bi-telephone-fill"></i> ${Ac.soDienThoai}
					</p>
				</div>
			</div>
			<!-- Product Configuration -->
			<div class="product-configuration"
				style="background-color: #f8f9fa; width: 100%; height: 180px; border-radius: 5px;">
				<div style="padding: 10px 10px 10px 10px">
					<a style="text-decoration: none; text-transform: uppercase;"
						href="ImgOfCameraControl?txtcamera=${detail.camera}"><img
						style="margin-right: 10px"
						src="https://img.icons8.com/ios/100/000000/compact-camera.png"
						width="35" height="35" />${detail.camera}</a>
					<div>
						<p>${detail.tieuCu}.0mm·${detail.khauDo} ·
							${detail.tocDoManTrap} · ISO ${detail.iSO}</p>
					</div>
					<div style="display: flex; justify-content: space-between;">
						<div>
							<p>
								<i class="bi bi-images"></i></i> Loại ảnh
							</p>
							<p>
								<i class="bi bi-calendar-check-fill"></i> Ngày đăng
							</p>
							<p>
								<i class="bi bi-eye-fill"></i> Lượt xem
							</p>
						</div>
						<div>
							<p>${detail.loaiHinhAnh}</p>
							<p>${detail.date}</p>
							<p>${detail.view}</p>
						</div>
					</div>
				</div>
			</div>
			<br>
			<p style="margin-bottom: 0px">Những hình ảnh liên quan</p>
			<div style="max-width: 100%; margin: 5px auto;">
				<div style="columns: 2 100px; gap: 5px;">
					<c:forEach items="${listImg_Cid}" var="I">
						<a href="ImageDetail?Iid=${idImage}&Uid=${Uid}&Cid=${Cid }}">
							<img style="margin-bottom: 5px; border-radius: 5px; width: 100%;"
							src="img/dataImg/${I.images}" alt="Lỗi">
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</main>
	<!-- Đổi inf -->

</body>
</html>