<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="date" uri="/tags"%>
<t:layout >
	<jsp:attribute name="header">
		<title>山水淡</title>
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
