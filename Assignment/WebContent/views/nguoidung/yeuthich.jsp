<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<title>Insert title here</title>
</head>
<body>
	<div class="trangchu__content">

		<form action="nguoidung" method="post" class="content__product">
			<c:forEach var="item1" items="${videolike}">
				<div class="content__product-sp">
					<div class="product-sp-img">
						<img src="/Assignment/imgs/${item1.poster}" alt="">
					</div>
					<div class="product-sp-title">
						<a href="">${item1.title}</a>
						<h1>${item1.id}</h1>
					</div>

					<div class="product-sp-like">
						<button
							formaction="/Assignment/nguoidung/danhsach/dish/${item1.id}">
							<i class='bx bxs-dislike'></i>Unlike
						</button>
						<a href=""><i class='bx bxs-share-alt'></i>Share</a>
					</div>
				</div>
			</c:forEach>
		</form>
	</div>
</body>
</html>