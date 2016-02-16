<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="date" uri="/tags"%>
<t:layout >
	<jsp:attribute name="header">
		<title>山水淡</title>
        <link href="img/u.png" type="image/png" rel="icon">

        <meta name="keywords" content="阅读，分享" />
        <meta name="description" content="阅读，分享">
        <!-- <#include "head.html"> -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <!-- 为移动设备添加 viewport -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <meta name="author" content="www.shanshuidan.com">
        <meta name="revised" content="uames,9/30/2015">

        <!-- 定义网页搜索引擎索引方式，使用英文逗号「,」分隔，常有如下几种取值：none,noindex,nofollow,all,index和follow -->
        <meta name="robots" content="index,follow" />

        <link rel="stylesheet" type="text/css" href="content/css/main.css">

        <script type="text/javascript" src="content/js/lib/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="content/js/lib/jquery.backstretch.min.js"></script>
        <script>
        $(function(){
        	$.backstretch([
                 "content/img/shanshui.jpg",
                 "content/img/startsky.jpg",
                 "content/img/greenleaf.jpg",
                 "content/img/lakeside.jpg"
             ], {
               fade: 750,
               duration: 4000
            });
        });
	        
    </script>
    </jsp:attribute>
	<jsp:body>
  		<%-- <t:header /> --%>
    	<div class="backstretch"></div>
	</jsp:body>
</t:layout>
