<%@ tag description="main footer" pageEncoding="UTF-8"%>
<div class="login-form fr">
	 <form action="member/postlogin" method="post" id="form">
		<div class="login-cont">
			<p class="welcome">欢迎来到藏金街</p>
			<div class="phone-number">
				<i></i><input type="text" class="number-txt" name="telphone" id="telphone" placeholder="用户名"/>
			</div>
			<p id="errtel"></p>
			<p class="forget">
				<a href="member/forgetpw/1" style="color:#5ba8ea;">忘记密码？</a>
			</p>
			<div class="password" id="pwd-div">
				<i></i><input type="password" class="pwd-txt" name="pwd" id="pwd" placeholder="密码"/>
			</div>
			<p id="errpwd"></p>
			<div class="login-btn">
				<a id="btn" href="javascript:;" >立即登录</a>
			</div>
			<p class="not-member">还没有账号？<a href="member/register">马上注册</a></p>
		</div>
	</form>
</div>
