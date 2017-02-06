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

	
	<form method="post">
	
	<c:forEach items="${form.formProperties}" var="fm">
	
		<div>
			<label>${fm.name }</label><input name="${fm.name }"/>
		</div>
	</c:forEach>
	
	<input type="hidden" name="deploymentId" value="${form.deploymentId}"/>
	<input type="hidden" name="formKey" value="${form.formKey}"/>
	
	<input type="submit" value="提交表单">
	
	</form>
	
	

</body>
</html>
