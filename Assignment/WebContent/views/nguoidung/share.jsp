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
			<h2>Send Video To Your Friend</h2>
			<h4>${message }</h4>
			<form action="nguoidung" method="post" class="tab-pane-form">
				<div class="form-input">
					<label>Your Friend's Email</label> <input name="emails" placeholder="Email?">
				</div>
				<div class="tab-button">
					<button formaction="/Assignment/nguoidung/send/${ad}">Send</button>
				</div>
			</form>
		</div>
</body>
</html>