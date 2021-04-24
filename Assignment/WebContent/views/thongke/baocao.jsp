<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/Assignment/views/css/thongke.css">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<title>Insert title here</title>
</head>
<body>
	<c:url var="thongke" value="/home/thongke" />
	<div class="content__thongke">
		<h3>Báo cáo - Thống kê</h3>
		<div class="content__thongke-tabs">
			<div class="content__thongke-tabs-items">
				<a href="${thongke }/thongke1">Favorites</a>
			</div>
			<div class="content__thongke-tabs-items">
				<a href="${thongke }/thongke2">Favorite Users</a>
			</div>
			<div class="content__thongke-tabs-items">
				<a href="${thongke }/thongke3">Share Friend</a>
			</div>
		</div>
		<div class="content__thongke-table">
			<jsp:include page="${view1 }" />
		</div>


	</div>
</body>
</html>