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
        <h2>Lấy lại mật khẩu</h2>
        <h4>${message }</h4>
        <form  action="/Assignment/nguoidung/quenmk" class="tab-pane-form" method="post">
            <div class="form-input">
                <label>Username</label>
                <input name="username" placeholder="Username?">
            </div>
          
            <div class="form-input">
                <label>Email</label>
                <input name="email" placeholder="Email?">
            </div>
            <div class="tab-button">
                <button formaction="/Assignment/nguoidung/quenmk/laymk">Retrieve</button>
            </div>
        </form>
    </div>
</body>
</html>