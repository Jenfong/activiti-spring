<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    
    <button> 流程图设计  </button>
    
    
    
    
   <form action="workflow/create" method="get">
   
   <div>
   	<label>name</label><input name="name"/>
   </div>
    <div>
   	<label>key</label><input name="key"/>
   </div>
    <div>
   	<label>description</label><input name="description"/>
   </div>
   
   <input type="submit" value="提交">
   
   
   </form>
    
    
  </body>
  
  	<a href="${rootURL }workflow/list">流程列表</a>
  
    <a href="${rootURL }dynamic/list">活动列表</a>
  
</html>
