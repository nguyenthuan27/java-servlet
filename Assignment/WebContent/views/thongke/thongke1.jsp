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
                                <th>Favorites Title</th>
                                <th>Favorite Count</th>
                                <th>Latest Date</th>
                                <th>Old Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${list}">
                                <tr>
                                    <td>${item.group}</td>
                                    <td>${item.like }</td>
                                    <td>${item.newest }</td>
                                    <td>${item.oldest}</td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
</body>
</html>