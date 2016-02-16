<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout >
	<jsp:attribute name="header">
		<title>新手指引-藏金街</title>
        <link rel="stylesheet" href="content/css/jquery.fullPage.css">
		<link rel="stylesheet" type="text/css" href="content/css/guide.css" />		
		<script src="${path}/content/js/lib/jquery1.8.3.min.js"></script>
        <script src="${path}/content/js/lib/jquery-ui.min.js"></script>
        <script src="${path}/content/js/lib/jquery.fullPage.min.js"></script>
        <script src="${path}/content/js/lib/jquery.slimscroll.min.js"></script>
		<script src="content/js/lib/require.mini.js" defer async="async" data-main="content/js/main/guide.js"></script>
        <script>
<!--		//扩展标签
			document.createElement('header');
			document.createElement('nav');
			document.createElement('figcaption');
			document.createElement('figure');
			document.createElement('section');
			document.createElement('article');
			document.createElement('aside');
			document.createElement('footer');
			document.createElement('hgroup');
        $(document).ready(function() {
			//alert(2222);
            $.fn.fullpage({
				scrollOverflow : true,
                anchors: ['page1', 'page2', 'page3','page4'],
                navigation: true
            });
        });
-->        </script>	
    </jsp:attribute>
	<jsp:body>
		<t:notice />
        <t:header />
        <t:nav />
                <div class="realize section">
                    <div style="padding-top:12%;">
                        <img src="${path}/content/images/page1.png" width="100%">
                    </div>
                </div>
                <div class="core section">
               	  <div style="padding-top:9%;">
                        <img src="${path}/content/images/page2.png" width="100%">   
                  </div>
                </div>
                <div class="product section">
               	  <div style="padding-top:2%;">
                        <img src="${path}/content/images/page3.png" width="100%">   
                  </div>
                </div>
                <div class="safety section">
                  <div style="padding-top:2%;">
                        <img src="${path}/content/images/page4.png" width="100%">   
                  </div>
                </div>
                <div class="choose-me section">
                    <div class="choose-pos"></div>
                  <div>
                        <img src="${path}/content/images/page5.png" width="100%">
                        <div class="div-a">
                            <a href="member/register"></a>
                        </div>   
                  </div>
                </div>
	</jsp:body>
</t:layout>
 