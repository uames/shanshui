package controller;

import uames.service.IUser;
import uames.service.impl.UserImpl;
import uames.util.HttpRequestDeviceUtils;

public class MemberController extends BaseController {
	public IUser iuser = new UserImpl();
	private static Integer _fails = 5;     // 失败次数 
	public MemberController() {
        super();
        viewPath = "/WEB-INF/view/";
    }
/*
 * getRequest().getSession().getServletContext().getRealPath("/")
 * */
    /**
	 * 登录
	 */
	public void login() {
		renderJsp("member/login.jsp");
	}


	/**
	 * 检查图片验证码是否正确
	 */
	public void checkcode() {
	    int status = 0;
	    if(tk.getIconCode().equals(getPara("code"))){
	        status = 1;
	    }else{
	        tk.getBrowse().setTelephone("");
	    }
		getJsonResult().setStatus(status);
		renderJson(getJsonResult());
	}

    
	/**
	 * 设置密码
	 * @throws Exception 
	 */
	public void setpwd() throws Exception {
	 //   String pkey = RSAUtil.generateKeyPairEx(getRequest());
		String tel = tk.getBrowse().getTelephone();
		setAttr("telphone", tel);
		renderJsp("member/setpwd.jsp");
	}

}
