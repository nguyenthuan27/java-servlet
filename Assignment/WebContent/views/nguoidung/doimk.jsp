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
		<h2>Đổi mật khẩu</h2>
		<h5>${message }</h5>
		<form action="/Assignment/nguoidung/doimk class="tab-pane-form" method="post">
			<div class="form-input">
				<label>Username</label> <input name="username"  readonly="readonly" value="${username }" placeholder="Username?">
			</div>
			<div class="form-input">
				<label>Password</label> <input name="password" type="password"
					placeholder="Password?">
			</div>
			<div class="form-input">
				<label>New Password</label> <input name="newpass" type="password"
					placeholder="Password?">
			</div>
			<div class="form-input">
				<label>Confirm Password</label> <input name="comfirmpass" type="password"
					placeholder="Password?">
			</div>
			<div class="tab-button">
				<button formaction="/Assignment/nguoidung/doimk/doi" >Đổi mật khẩu</button>
			</div>
		</form>
	</div>
</body>
</html>