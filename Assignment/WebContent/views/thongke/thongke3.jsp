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
							<c:forEach var="item" items="${shalist}">
								<tr>
									<td>${item.sendername}</td>
									<td>${item.senderemail }</td>
									<td>${item.receivermail }</td>
									<td>${item.senddate}</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</body>
</html>