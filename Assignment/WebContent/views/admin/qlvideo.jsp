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
			<h3>Thông tin Video</h3>
			<h5>${message}</h5>
			<form action="home" class="tab-pane-form" method="post"
				enctype="multipart/form-data">
				<div class="pan-form-img">
					<img src="/Assignment/imgs/${form.poster}"> <label
						for="files" class="btn">Thêm ảnh <a>${form.poster}</a></label> <input
						name="poster" id="files" style="visibility: hidden;" type="file">
	
<h2>${form.active}</h2>
				</div>
				<div class="tab-pane-form-size">
					<div class="form-input1">
						<label>Youtube ID</label> <input name="id" value="${form.id}"
							placeholder="Youtube ID ?">
					</div>
					<div class="form-input1">
						<label>Video Title</label> <input name="title"
							value="${form.title}" placeholder="Video Title ?">
					</div>
					<div class="form-input1">
						<label>Video Cout</label> <input name="viewss"
							value="${form.viewss}" placeholder="Video Cout ?">
					</div>
					<div class="form-input1-active">
						<label>Active</label> <input ${form.active?'checked':''}
							name="active" type="radio" value="true"> <label>InActive</label>
						<input ${form.active?'':'checked'} name="active" type="radio"
							value="false">

					</div>
				</div>
				<div class="form-textarea">
					<label>Active</label>
					<textarea name="descriptions" id="" cols="50" rows="4">${form.descriptions }</textarea>
				</div>

				<div class="show-btn">
					<button formaction="/Assignment/home/qlvideo/createVideo">Insert</button>
					<button formaction="/Assignment/home/qlvideo/updateVideo">Update</button>
					<button formaction="/Assignment/home/qlvideo/deleteVideo">Delete</button>
					<button >Reset</button>
				</div>
			</form>
		</div>
		<div class="pane-form-table">
			<div class="pane-searh">
				<input placeholder="Search....">
				<button>Tìm kiếm</button>
			</div>
			<table>
				<thead>
					<tr>
						<th>Youtube ID</th>
						<th>Video Title</th>
						<th>View Count</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${items}">
						<tr>
							<td>${item.id}</td>
							<td>${item.title }</td>
							<td>${item.viewss }</td>
							<td>${item.active==true?"active":"inactive"}</td>
							<td><a href="/Assignment/home/qlvideo/edit/${item.id}"
								class="edit">Edit</a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>