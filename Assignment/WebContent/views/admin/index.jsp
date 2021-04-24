<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <link rel="stylesheet" href="/Assignment/views/css/admin.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<title>Insert title here</title>
</head>
<body>
<c:url var="home" value="/home"/>
<div class="container">
        <div class="sidebar__title">
            <div class="sidebar__img">
                <h2>Quản trị viên</h2>
            </div>
        </div>
        <nav class="navbar">
            <div class="navbar__left">
                <a class="active_link" href="#">Admin</a>
            </div>
            <div class="navbar__right">
                <a href="">nguyenthuan27</a>
                <i class="fas fa-user-circle"></i>
            </div>
        </nav>
    </div>
    <div class="contai">
        <div class="dt">
            <div class="tabs">
                <div class="tab-item">
                    <i class="fa fa-home"></i>
                    <a href="${home }/trangchu">Trang chủ</a>
                </div>
                <div class="tab-item">
                    <i class="fab fa-youtube"></i>
                    <a href="${home }/qlvideo"> Quản lý video</a>
                </div>
                <div class="tab-item">
                    <i class="fas fa-users"></i>
                    <a href="${home }/qlusers"> Quản lý người sử dụng</a>
                </div>
                <div class="tab-item">
                    <i class="fas fa-chart-pie"></i>
                    <a href="${home }/thongke"> Báo cáo - Thống kê</a>
                </div>
                <div class="line"></div>
                <div class="sidebar__logout">
                    <i class="fa fa-power-off"></i>
                    <a href="#">Log out</a>
                </div>
            </div>
        </div>
        <div class="content">
        <jsp:include page="${view }" />
        </div>
    </div>
</body>
</html>