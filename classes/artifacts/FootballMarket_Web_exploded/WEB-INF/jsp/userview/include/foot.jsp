<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>足球俱乐部周边线上销售平台</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- 尾部 -->
    <hr/>
    <div class="foot-style" style="background-color:#140a47">
      	<span style="color:#fff">Copyright © 2022-2023  ustl.com 版权所有&nbsp&nbsp|&nbsp&nbsp辽宁科技大学</span>
        <br/>
        	<span style="color:#fff">足球俱乐部周边线上销售平台</span>
    </div>
    <!-- 结束啦 -->

</body>
</html>