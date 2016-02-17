<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="date" uri="/tags"%>
<t:layout >
	<jsp:attribute name="header">
		<title>每日三件事-山水淡</title>
        <link rel="stylesheet" type="text/css" href="content/css/plan.css">
        <script src="content/js/lib/require.mini.js" defer async="async" data-main="content/js/plan/index.js"></script>
    </jsp:attribute>
	<jsp:body>
  		<%-- <t:header /> --%>
    	<div class="backstretch"></div>
	</jsp:body>
</t:layout>
