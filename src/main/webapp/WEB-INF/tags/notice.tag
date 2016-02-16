<%@ tag description="main header" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${fn:length(maa)>0}">
    <div class="top">
        <div class="news">
            <div class="activity_out"> 
            <span class="news_notice"></span>
             <p class="news_activity">
                <c:forEach items="${maa}" var="med" varStatus="loop">
                    <a href="home/notice">${med.po.title }</a>
                </c:forEach>
             </p>
            </div>
        </div>    
    </div>
</c:if>

