<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib  prefix="date" uri="/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout >
	<jsp:attribute name="header">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
		<title>藏金街</title>
        <link type="text/css" rel="stylesheet" href="content/css/mapp.css" />
        <script src="content/js/lib/require.mini.js" defer async="async" data-main="content/js/m/reg.js"></script>
        <script src="content/js/m/swipe.js"></script>	
    </jsp:attribute>
	<jsp:body>
        <div class="page">
            <header>
                <a href="javascript:;" class="logo fl"><em></em>藏金街</a>
                <a href="m/mregister" class="register fr">注册</a>
            </header>
            <div class="banner" id="canvas">
            </div>
            <div class="section">
                <h3 class="hot-sale">藏金街热卖产品</h3>
                <section class="product">
                    <p class="product-name">藏金街新手专享<span class="periods">期限15天</span></p>
                    <p><span class="expect fl">预期年化收益</span><span class="buy-count fr">30天购买人数<em></em></span><span class="clear"></span></p>
                    <p class="pad-bot"><span class="fl expect-num">10.00<label>%</label></span><span class="fr per-count">6546<label>人</label></span><span class="clear"></span></p>
                </section>
                <section class="product">
                    <p class="product-name">藏金街新手专享<span class="periods">期限15天</span></p>
                    <p><span class="expect fl">预期年化收益</span><span class="buy-count fr">30天购买人数<em></em></span><span class="clear"></span></p>
                    <p class="pad-bot"><span class="fl expect-num">10.00<label>%</label></span><span class="fr per-count">6546<label>人</label></span><span class="clear"></span></p>
                </section>
                <section class="product">
                    <p class="product-name">藏金街新手专享<span class="periods">期限15天</span></p>
                    <p><span class="expect fl">预期年化收益</span><span class="buy-count fr">30天购买人数<em></em></span><span class="clear"></span></p>
                    <p class="pad-bot"><span class="fl expect-num">10.00<label>%</label></span><span class="fr per-count">6546<label>人</label></span><span class="clear"></span></p>
                </section>
                <section class="product">
                    <p class="product-name">藏金街新手专享<span class="periods">期限15天</span></p>
                    <p><span class="expect fl">预期年化收益</span><span class="buy-count fr">30天购买人数<em></em></span><span class="clear"></span></p>
                    <p class="pad-bot"><span class="fl expect-num">10.00<label>%</label></span><span class="fr per-count">6546<label>人</label></span><span class="clear"></span></p>
                </section>
                <section class="product">
                    <p class="product-name">藏金街新手专享<span class="periods enchashment">随时取现</span></p>
                    <p><span class="expect fl">预期年化收益</span><span class="buy-count fr">30天购买人数<em></em></span><span class="clear"></span></p>
                    <p class="pad-bot"><span class="fl expect-num">10.00<label>%</label></span><span class="fr per-count">6546<label>人</label></span><span class="clear"></span></p>
                </section>
            </div>
            <footer>
                <a href="javascript:;" class="download">立即下载</a>
            </footer>
        </div>
	</jsp:body>
</t:layout>
 