<%@ tag description="main header" pageEncoding="UTF-8"%>
<%@ attribute name="current"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<div class="nav_bg">
		<div class="nav_out">
			<div class="logo">
				<h1>
					<a href="" class="index"><img width="104" height="51" src="content/images/logo(2).png" /></a>
					<img src="content/images/logo.png" width="275" height="49" />
				</h1>
			</div>
			<ul class="nav">
				<li <c:if test="${current==null || current==0}">class="current special"</c:if>>
					<a href="${tk.unSslHost }">
						<span class="chiness">首页</span>
						<span class="english">HOME</span>
					</a>
				</li>
				<li <c:if test="${current==1}">class="current"</c:if>>
					<a href="goods/list">
						<span class="chiness">我要投资</span>
						<span class="english">INVESTMENT</span>
					</a>
				</li>
<%-- 				<li <c:if test="${current==2}">class="current"</c:if>>
					<a href="${tk.unSslHost }store">
						<span class="chiness">黄金商城</span>
						<span class="english">GOLD MALL</span>
					</a>
				</li> --%>
				<li <c:if test="${current==3}">class="current"</c:if> id="new-remind">
					<a href="home">
						<span class="chiness">我的藏金</span>
						<span class="english">MEMBER CENTER</span>
					</a>
					<c:if test="${msgnum != '0' && msgnum != null }"><label>${msgnum }</label></c:if>
				</li>
				<li <c:if test="${current==4}">class="current"</c:if>>
					<a href="${tk.unSslHost }doc/3-111">
						<span class="chiness">关于藏金街</span>
						<span class="english">ABOUT US</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="nav_shadow"></div>
</nav>
