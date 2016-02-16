<%@ tag description="main header" pageEncoding="UTF-8"%>
<%@ attribute name="current"%>
<%@ attribute name="cur_home"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
String getForce(Integer i, String v) {
	return Integer.valueOf(v) == i ? " class=\"all\"" : "";
}
%>
<aside class="aside">
	<div class="my_message">
		<p class="hello">${tk.nowTime }好！</p>
		<p class="name">
			<span class="my_name" id="my_name" style="font-size:16px">${tk.user.nick_name }</span>
			<span class="normal"></span>
		</p>
		<p class="unread"><a href="home/message"><span>${msgnum }</span></a>封未读消息</p>
		<p class="safety_grade">
		<span>安全等级：</span>
		<span class="grade">${tk.user.securityMsg }</span>
		<span class="grade_m_pic ${tk.user.securityStatus == 1 ? ' grade_orange' : tk.user.securityStatus == 2 ? ' grade_yellow' : tk.user.securityStatus >= 3 ? ' grade_green' : ''}"></span>
		</p>
		<p class="isverify">
			<a class="tel" href="home/security"><i class="yes"></i></a>
			<a class="lock" href="home/security"><i class="${tk.user.po.is_checked==1 || tk.user.po.is_checked==2 ? 'yes' : 'no'}"></i></a>
			<a class="message" href="home/security"><i class="${tk.user.po.email_status==1 || tk.user.po.email_status==2 ? 'yes' : 'no'}"></i></a>
			<a class="card" href="home/info"><i class="${tk.user.po.identification!=null ? 'yes' : 'no'}"></i></a>
		</p>
	</div>
	<div class="nav_left">
		<h4 class="one"><span class="icon"></span>我的藏金</h4>
		<a href="home/index" id="a_nav" <c:if test="${cur_home==null || cur_home==0}">class="cur_home"</c:if>>账户总览</a>
		<a href="home/info" id="a_nav" <c:if test="${cur_home==1}">class="cur_home"</c:if>>个人信息</a>
		<a href="home/message" id="a_nav" <c:if test="${cur_home==2}">class="cur_home"</c:if>>我的消息</a>
		<h4 class="two"><span class="icon"></span>我的投资</h4>
		<a href="home/record/1" id="a_nav" <c:if test="${cur_home==3}">class="cur_home"</c:if>>投资记录</a>
		<a href="home/autoinvest" id="a_nav" <c:if test="${cur_home==4}">class="cur_home"</c:if>>自动续投</a>
		<h4 class="three"><span class="icon"></span>黄金商城</h4>
		<a href="home/scoreflow" id="a_nav" <c:if test="${cur_home==5}">class="cur_home"</c:if>>我的黄金币</a>
		<a href="home/scorerecord" id="a_nav" <c:if test="${cur_home==6}">class="cur_home"</c:if>>兑换记录</a>
		<%--<a href="home/couponsmgr/1" id="a_nav" <c:if test="${cur_home==11}">class="cur_home"</c:if>>带金券管理</a>--%>
		<h4 class="four"><span class="icon"></span>账户管理</h4>
		<a href="home/security" id="a_nav" <c:if test="${cur_home==7}">class="cur_home"</c:if>>账户安全</a>
		<a href="home/bkmgr" id="a_nav" <c:if test="${cur_home==8}">class="cur_home"</c:if>>银行卡管理</a>
		<a href="home/couponsmgr/1" id="a_nav" style="padding-left:32px;" <c:if test="${cur_home==11}">class="cur_home"</c:if>><em class="icon" style="	background-position:-148px 0;top:8px;"></em>带金券管理</a>
		<a href="home/referee" id="a_nav" style="padding-left:32px;" <c:if test="${cur_home==9}">class="cur_home"</c:if>><em class="icon" style="	background-position:-177px 0;top:8px;"></em>邀请好友</a>
		<a href="home/notice" id="a_nav" style="padding-left:32px;" <c:if test="${cur_home==10}">class="cur_home"</c:if>><em class="icon" style="	background-position:-25px -27px;top:8px;"></em>系统公告</a>
	</div>
	<div class="body_bg"></div>
	<div class="delete_tips">
		<p class="tips">确定删除该记录？</p>
	    <div class="tips_btn">
			<a href="javascript:;" class="tips_yes">是</a>
			<a href="javascript:;" class="tips_no">否</a>
	    </div>
	</div>

	
</aside>


