<%@ tag description="main header" pageEncoding="UTF-8" %>
<%@ attribute name="current" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>

<nav>
	<div class="nav_out">
		<div class="logo">
			<h1>
				<a href="/user"><img src="content/images/logo.png" /></a>
			</h1>
		</div>
		<ul class="nav">
			<li <c:if test="${current==null || current==0}">class="current"</c:if>><a href="${path}">首页</a></li>
			<li <c:if test="${current==1}">class="current"</c:if>><a href="${path}/goods/list">产品</a></li>
			<li <c:if test="${current==2}">class="current"</c:if>><a href="${path}/store">商城</a></li>
			<li <c:if test="${current==3}">class="current"</c:if>><a href="${path}/mytransaction">我的</a></li>
			<li <c:if test="${current==4}">class="current"</c:if>><a href="${path}/contact">联系我们</a></li>
			<li <c:if test="${current==5}">class="current"</c:if>><a href="${path}/help">帮助中心</a></li>
		</ul>
	</div>
</nav>
</header>
