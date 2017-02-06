<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>流程列表</title>
<link rel="stylesheet"
	href="${rootURL }editor-app/libs/bootstrap_3.1.1/css/bootstrap.min.css" />
<script src="${rootURL }editor-app/libs/jquery_1.11.0/jquery.min.js"></script>
<script src="${rootURL }editor-app/libs/jquery-ui-1.10.3.custom.min.js"></script>
<script
	src="${rootURL }editor-app/libs/bootstrap_3.1.1/js/bootstrap.min.js"></script>
</head>
<body>

	<table class="table table-hover">

		<tr>
			<td>名称</td>
			<td>id</td>
			<td>key</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="m">
			<tr>
				<td>名称</td>
				<td>${m.id }</td>
				<td>${m.key }</td>
				<td><a href="${rootURL }workflow/deploy/${m.id }">部署</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>
