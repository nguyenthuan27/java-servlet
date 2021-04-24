<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/Assignment/views/css/dangki.css">
<title>Insert title here</title>
</head>
<body>
<div class="tab-pane1">
		<h2>Thay đổi thông tin</h2>
		<form class="tab-pane-form" action="nguoidung" method="post">
		<h3>${message }</h3>
			<div class="form-input">
				<label>Username</label> <input name="id" readonly="readonly" value="${users.id }" placeholder="Username?">
			</div>
			<div class="form-input">
				<label>Password</label> <input name="password" value="${users.password}" type="password"
					placeholder="Password?">
			</div>
			<div class="form-input">
				<label>Fullname</label> <input name="fullname" value="${users.fullname }" placeholder="Fullname?">
			</div>
			<div class="form-input">
				<label>Email</label> <input name="email" value="${users.email }" placeholder="Email?">
			</div>
			<div class="tab-button">
				<button formaction="/Assignment/nguoidung/thaydoitt/updatett">Update</button>
			</div>
		</form>
	</div>
</body>
</html>