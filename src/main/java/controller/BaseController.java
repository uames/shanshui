package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;

import uames.po.Article;
import uames.service.impl.ArticleImpl;
import uames.util.UamesUtil;
import uames.util.HttpRequestDeviceUtils;
import uames.util.Toolkit;
import uames.vo.ArticleVo;
import uames.vo.WebResult;

public class BaseController extends Controller {
    
    @SuppressWarnings("unused")
    private static Logger log = Logger.getLogger(BaseController.class);
	protected Toolkit tk;
	protected String viewPath = "";
	private WebResult jsonResult;
	public Integer pageSize;
	
	public BaseController() {
		super();
	    tk = new Toolkit(this);
		pageSize = 16;
	}
	public WebResult getJsonResult () {
	    if (jsonResult == null) {
	        jsonResult = new WebResult();
	    }
	    return jsonResult;
	}
	
	/**
	 * 手机web可以访问的页面
	 * @param f 要访问的页面的jsp文件路径
	 * @return
	 */
	private boolean getPhoneJsp(String f){
	    return !(UamesUtil.getUri(getRequest()).contains("/m/")) && !f.contains("/m/")
        && !getRequest().getRequestURL().toString().contains("/doc/share")
        && !getRequest().getRequestURL().toString().contains("/member/phonereg")
        && !getRequest().getRequestURL().toString().contains("/member/register");
	}
	
	@Override
	public void renderJsp(String f) {
	    setAttr("tk", tk);
	    List<Article> menus = new ArrayList<Article>();
        menus = new ArticleImpl().queryBySql(" cat_id= 16 ",0,0);
        setAttr("maa", ArticleVo.createList(menus)); 
        
	     
	    //f=f.substring(0,f.lastIndexOf("/")+1)+ "mobile/" + f.substring(f.lastIndexOf("/")+1);
	    
	    if(HttpRequestDeviceUtils.isMobileDevice(getRequest()) && getPhoneJsp(f)){
	        this.redirect(tk.getSslHost() + "/m/index");
	    }else{
	        if(tk.getIsLogin() && !UamesUtil.getIpAddr(getRequest()).equals(tk.getBrowse().getLogin_ip())
	                && getPhoneJsp(f)){
              //>  tk.setNewBrowse();
                setAttr("ipchange", "true");
                //this.redirect(tk.getSslHost() + "/member/logout");
            }else{
                setAttr("ipchange", "false");
            }
            super.renderJsp(viewPath + f);
	    }
	}
}
