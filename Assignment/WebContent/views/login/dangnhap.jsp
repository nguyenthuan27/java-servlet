<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/Assignment/views/css/login.css">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<div class="title">Login Form</div>
		<h3>${message }</h3>
		<form action="/Assignment/login" method="post">
			<div class="field">
				<input  name="username" type="text" required> <label>User Name</label>
			</div>
			<div class="field">
				<input name="password" type="password" required> <label>Password</label>
			</div>
			<div class="content">
				<div class="checkbox">
					<input type="checkbox" id="remember" name="remember"> <label
						for="remember-me">Remember me</label>
				</div>
				<div class="pass-link">
					<a href="#">Forgot password?</a>
				</div>
			</div>
			<div class="field">
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
</body>
</html>