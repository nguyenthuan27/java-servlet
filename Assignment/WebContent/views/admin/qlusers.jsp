<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <link rel="stylesheet" href="/Assignment/views/css/show.css">
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<title>Insert title here</title>
</head>
<body>
<div class="tabs1">
        <div class="content-form">
            <h3>Thông tin người dùng</h3>
            <h5>${message}</h5>
            <form action="home" class="tab-pane-form" method="post">
                <div class="tab-pane-form-siz2">
                    <div class="form-input1">
                        <label>User Name</label>
                        <input name="id" value="${form.id}" placeholder="User Name ?">
                    </div>
                    <div class="form-input1">
                        <label>PassWord</label>
                        <input name="password" value="${form.password}" type="password" placeholder="PassWord ?">
                    </div>
                    <div class="form-input1">
                        <label>FullName</label>
                        <input name="fullname" value="${form.fullname}" placeholder="FullName ?">
                    </div>
                    <div class="form-input1">
                        <label>Email Address</label>
                        <input name="email" value="${form.email}" placeholder="Email Address ?">
                    </div>
                </div>
                <div class="show-btn">
                    <button formaction="/Assignment/home/qlusers/updateUser">Update</button>
                    <button formaction="/Assignment/home/qlusers/deleteUser">Delete</button>
                    <button>Reset</button>
                </div>
            </form>
        </div>
        <div class="pane-form-table">

            <table>
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Full Name</th>
                        <th>Email Address</th>
                        <th>Role</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.password }</td>
                            <td>${item.fullname }</td>
                            <td>${item.email}</td>
                            <td>${item.admin==true?"Admin":"User"}</td>
                            <td><a href="/Assignment/home/qlusers/edit/${item.id}" class="edit">Edit</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>