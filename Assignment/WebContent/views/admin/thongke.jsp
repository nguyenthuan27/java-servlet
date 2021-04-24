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
	<div class="thongke">
		<h1 class="title">Báo cáo - Thống kê</h1>
		<div class="tabContainer">
			<div class="buttonContainer">
				<button onclick="showPanel(0)">Favorites</button>
				<button onclick="showPanel(1)">Favorite Users</button>
				<button onclick="showPanel(2)">Shared Friends</button>
			</div>
			<div class="tabPanel">
				<div class="pane-form-table">

					<table>
						<thead>
							<tr>
								<th>Favorites Title</th>
								<th>Favorite Count</th>
								<th>Latest Date</th>
								<th>Old Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${list}">
								<tr>
									<td>${item.group}</td>
									<td>${item.like }</td>
									<td>${item.newest }</td>
									<td>${item.oldest}</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tabPanel">
				<div class="pane-form-table">
					<div class="pane-searh">
					<form action="/Assignment/home/thongke/select" method="post" id ="select1">
					
						<select name="videoids" onchange="select('POST')">
							<c:forEach var="item" items="${vlist}">
								<option>${item.title }</option>
							</c:forEach>
						</select>
						
					</form>
					</div>
					<table>
						<thead>
							<tr>
								<th>Username</th>
								<th>FullName</th>
								<th>Email</th>
								<th>Favorite Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${listlike}">
								<tr>
									<td>${item.id}</td>
									<td>${item.fullname }</td>
									<td>${item.email}</td>
									<td>${item. likedate}</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tabPanel">
				<div class="pane-form-table">
					<div class="pane-searh">
						<input placeholder="Search....">
						<button>Tìm kiếm</button>
					</div>
					<table>
						<thead>
							<tr>
								<th>Sender Name</th>
								<th>Sender Email</th>
								<th>Receiver Email</th>
								<th>Send Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${items}">
								<tr>
									<td>${item.id}</td>
									<td>${item.password }</td>
									<td>${item.fullname }</td>
									<td>${item.email}</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function select(methodType) {
			document.getElementById("select1").action = "/Assignment/home/thongke/select";
			document.getElementById("select1").method = methodType;
			document.getElementById("select1").submit();
			showContent('Favorites User');
		}
	</script>
	<script src="/Assignment/views/script.js"></script>
</body>
</html>