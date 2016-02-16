<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
	<jsp:attribute name="header">
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="content/css/login.css" />
		<script src="content/js/lib/require.mini.js" defer async="async" data-main="content/js/member/login.js"></script>
		<script>
<!--        //扩展标签
            document.createElement('header');
            document.createElement('nav');
            document.createElement('figcaption');
            document.createElement('figure');
            document.createElement('section');
            document.createElement('article');
            document.createElement('aside');
            document.createElement('footer');
            document.createElement('hgroup');
-->     </script>
	</jsp:attribute>
	<jsp:body>
	<t:notice />
		<t:header />
		<t:nav current="5" />
	<div class="cjj-top">
		<div class="top-cont clr">
			<div class="login-img">
				 <img src="${path}/content/images/login_bg3.png" class="fl">  
			</div>
			<t:login />
		</div>
	</div>
	<div class="hr"></div>
	<input type="hidden" value="${istrue }" id="istrue"/>
	<t:footer />
	</jsp:body>
</t:layout>
