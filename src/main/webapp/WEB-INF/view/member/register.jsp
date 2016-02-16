<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout>
	<jsp:attribute name="header">
		<title>注册页面</title>
   	    <link type="text/css" rel="stylesheet" href="content/css/register.css" />
   	    <script src="content/js/lib/require.mini.js" defer async="async" data-main="content/js/member/register.js"></script>

    </jsp:attribute>
	<jsp:body>
		<t:header_member title="欢迎注册" />
      <!--condition-->
    <div id="condition_out">
        <div class="register-pic"></div>
    </div>
    <!--condition-->
    <div id="con_out">
    	<form action="member/setpwd" id="form" method="post">
        	<ul class="con">
            	<li class="one">
                    <div style="float:left;">
                        <span class="first">手机号：</span>
                    	<input type="text" class="text" name="telphone" id="telphone" value="${vo.account}" placeholder="请输入手机号" />
                    </div>
					<span id="errtel" class="register-tips tips-fl-spec">请输入常用手机号</span>
                </li>
                <li class="two">
                	<div class="left">
                        <span class="first">验证码：</span>
                        <input type="text" class="text text02" name="code_icon" id="code_icon" placeholder="请输入验证码" />
                    </div>
                    <div class="right_icon">
	                    <div class="r_r">
	                    	<img  src="member/generator" id="codeImg">
						</div>
	                    <span class="next">看不清？<a href="javascript:;" id="chgCode">换一张</a></span>
	                </div>
                    <span id="errcode_icon" class="register-tips tips-fl">请输入图片中的字符，不区分大小写</span>
                </li>
                <li class="two ml-minus">
                	<div class="left">
                        <span class="first less-padding">短信验证码：</span>
                        <input type="text" class="text text02" name="code" id="code" placeholder="请输入验证码" />
                    </div>
                    <div class="right">
                    <span class="code-btn" id="getcode" data-disable="0">
	                    获取短信验证码
	               		</span>
	                </div>
                     <span id="errcode" class="register-tips tips-fl">请填写你手机收到的验证信息</span>
                </li>
                <li class="three">
                	<input type="checkbox" id="chkTerm" class="checkbox" data-id="0" />
                    <span class="read">我已阅读并同意<a href="doc/help/2-86">《藏金街注册协议》</a></span>
                </li>
                <li class="btn-center">
                    <div class="btn-center_div">
                	   <input type="button" class="btn" name="btn" id="btn" value="下一步" />
                       <p class="has-member">已有账号？<a href="member/login">立即登录>></a></p>
                    </div>
                </li>
            </ul>
        </form>
    </div>
    <!--contion-->
        <div id="footer_pre"></div>
    	<t:footer />
    </jsp:body>
</t:layout>
