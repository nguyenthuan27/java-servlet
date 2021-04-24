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
	<div class="trangchu__content">
		<form action="nguoidung" method="post" class="content__products">
		<div class="content__product">
		
			<c:forEach var="item" items="${items}">
				<div class="content__product-sp">
					<a class="product-sp-img"
						href="/Assignment/nguoidung/xemvideo/${item.id }"> <img
						src="/Assignment/imgs/${item.poster}">
					</a>
					<div class="product-sp-title">
						<a href="">${item.title}</a>
					</div>
					<div class="product-sp-like">
						<button class="button" formaction="/Assignment/nguoidung/danhsach/like/${item.id }">
							<i class='bx bxs-like'></i>Like
						</button>
						<a class="button" href="/Assignment/nguoidung/share/${item.id }">
							<i class='bx bxs-share-alt'></i>Share
						</a >
					</div>
				</div>
			</c:forEach>
		</div>
			<div class="btn-chuyen">
			<button formaction="/Assignment/nguoidung/dau"><i class='bx bxs-chevrons-left'></i></button>
			<button formaction="/Assignment/nguoidung/xuong/${items[0].id}"><i class='bx bxs-chevron-left' ></i></button>
			<button formaction="/Assignment/nguoidung/len/${items[0].id}"><i class='bx bxs-chevron-right' ></i></button>
			<button formaction="/Assignment/nguoidung/cuoi"><i class='bx bxs-chevrons-right' ></i></button>

			</div>
		</form>
		
	</div>

</body>
</html>