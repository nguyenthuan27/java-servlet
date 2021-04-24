<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/Assignment/views/css/nguoidung.css">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when
			test="${sessionScope.username.admin ==false || empty sessionScope.username }">
			<c:url var="nguoidung" value="/nguoidung" />
			<div class="container__admin">
				<div class="trangchu__menu">
					<ul>
						<li><a href="${nguoidung }/danhsach">Trang chủ</a></li>
						<li><a href="${nguoidung }/yeuthich">My Favorite</a></li>
						<li><a>My account: ${sessionScope.username.id }</a>
							<ul>
								<li><a href="${nguoidung }/dangnhap">Đăng nhập</a></li>
								<li><a href="${nguoidung }/quenmk">Quên mật khẩu</a></li>
								<li><a href="${nguoidung }/dangki">Đăng kí</a></li>
								<li><a href="/Assignment/logout">Đăng xuất</a></li>
								<li><a href="${nguoidung }/doimk">Đổi mật khẩu</a></li>
								<li><a href="${nguoidung }/thaydoitt">Thay đổi thông
										tin</a></li>
							</ul>
					</ul>
				</div>
				<div class="gird">
					<div class="trangchu__content-aa">
						<jsp:include page="${view3}" />
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<jsp:include page="/views/login/home.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>