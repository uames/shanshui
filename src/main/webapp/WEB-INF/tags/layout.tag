<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true"%>
<!doctype html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">      
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta http-equiv="test-x-ssl" content="${x_ssl}">
<link rel="stylesheet" type="text/css" href="content/css/common.css" />
<link rel="icon" href="content/images/cang.ico" type='image/x-ico' />
<link rel="shortcut  icon" href="content/images/cang.ico" />
<jsp:invoke fragment="header" />
</head>
<body>
	<jsp:doBody />
	<input type="hidden" value="${path}" id="webroot" />
	<input type="hidden" value="${ipchange }" id="ipchange" />
</body>
</html>

