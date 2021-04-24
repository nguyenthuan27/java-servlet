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
		<h2>Đăng kí tài khoản</h2>

		<form action="nguoidung" method="post" class="tab-pane-form">
		<h5>${message }</h5>
			<div class="form-input">
				<label>Username</label> <input name="id" placeholder="Username?">
			</div>
			<div class="form-input">
				<label>Password</label> <input name="password" type="password"
					placeholder="Password?">
			</div>
			<div class="form-input">
				<label>Fullname</label> <input name="fullname" placeholder="Fullname?">
			</div>
			<div class="form-input">
				<label>Email</label> <input name="email" placeholder="Email?">
			</div>
			<div class="tab-button">
				<button formaction="/Assignment/nguoidung/dangki/themtk">Đăng kí</button>
			</div>
		</form>
	</div>
</body>
</html>