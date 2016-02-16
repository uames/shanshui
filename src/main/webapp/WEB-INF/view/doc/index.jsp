<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout_doc >
	<jsp:body>
	${vo.po.content}
	<input type="hidden" id="art_type" value="${vo.po.cat_id }" />
	</jsp:body>
</t:layout_doc>