<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout_help >
	<jsp:body>
	${vo.po.content}
	<input id="art_id" value="${vo.po.id}" style="display:none"/>
	</jsp:body>
</t:layout_help>
