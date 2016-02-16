<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout_doc >	
	<jsp:body>
    <div class="imgBox_out">
    	<c:forEach items="${fls}" var="fl" varStatus="loop">
    		<div class="img-text">
                <a class="f_img" href="${fl.po.link_url }"><img src="${fl.po.img }" max-width='145px' max-height="75px"/></a>
                <a class="f_img_text" href="${fl.po.link_url }">${fl.po.link_name }</a>
            </div>
		</c:forEach>
    </div>
		<script src="content/js/lib/require.mini.js" defer async="async" data-main="content/js/main/contact.js"></script>
	</jsp:body>
</t:layout_doc>