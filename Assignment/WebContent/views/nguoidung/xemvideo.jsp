<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/Assignment/views/css/hienthivideo.css">
<title>Insert title here</title>
</head>
<body>
	<div class="page__chitiet">
		<div class="page__chitiet-videos">
			<div class="page__chitiet-videos-run">
				<div class="videos-run-frame">
					<iframe src="${ad.descriptions }"></iframe>
				</div>
			</div>
			<div class="page__chitiet-videos-title">
				<h3>${ad.title }</h3>
			</div>
			<div class="page__chitiet-videos-description">
				<h4>${ad.descriptions }</h4>
			</div>
			<div class="page__chitiet-videos-sukien">
				<div class="videos-sukien-item">
					<a href=""><i class='bx bxs-like'></i>Like</a> <a href=""><i
						class='bx bxs-share-alt'></i>Share</a>
				</div>
			</div>
		</div>
		<div class="page__chitiet-videowatch">
			<div class="page__chitiet-videowatch-scroll">
				<div class="page__chitiet-videowatch-infor">
					<div class="videowatch-infor-image">
						<img src="/img/3.jpg" alt="">
					</div>
					<div class="videowatch-infor-title">
						<a href="">K391, Alan Walker</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>