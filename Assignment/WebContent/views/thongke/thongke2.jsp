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
	<div class="tabPanel">
		<div class="pane-form-table">
			<div class="pane-searh">
				<form action="/Assignment/home/thongke/select" method="post"
					id="select1">
					<select name="videoids" onchange="select('POST')">
						<option>---chon----</option>
						<c:forEach var="item" items="${vlist}">
							<option value="${item.title}">${item.title}</option>
						</c:forEach>
					</select>

					<table>
						<thead>
							<tr>
								<th>Username</th>
								<th>FullName</th>
								<th>Email</th>
								<th>Favorite Date</th>
								<th>Title Video Like</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${listlikevideo}">
								<tr>
									<td>${item.id}</td>
									<td>${item.fullname }</td>
									<td>${item.email}</td>
									<td>${item.likedate}</td>
									<td>${item. title}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function select(methodType) {
			document.getElementById("select1").action = "/Assignment/home/thongke/select";
			document.getElementById("select1").method = methodType;
			document.getElementById("select1").submit();
		}
	</script>
</body>
</html>