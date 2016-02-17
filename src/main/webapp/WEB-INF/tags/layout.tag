<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true"%>
<!doctype html>
<html>
<head>
<base href="${basePath}">
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">      
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="test-x-ssl" content="${x_ssl}">
<meta name="keywords" content="阅读，分享">
<meta name="description" content="阅读，分享">
<!-- 为移动设备添加 viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 定义网页搜索引擎索引方式，使用英文逗号「,」分隔，常有如下几种取值：none,noindex,nofollow,all,index和follow -->
<meta name="robots" content="index,follow" />

<meta name="author" content="www.shanshuidan.com">
<meta name="revised" content="uames,9/30/2015">

<link rel="stylesheet" type="text/css" href="content/css/common.css" />
<link rel="icon" href="content/img/u.png" type="image/png" />
<jsp:invoke fragment="header" />
</head>
<body>
	<jsp:doBody />
	<input type="hidden" value="${path}" id="webroot" />
</body>
</html>