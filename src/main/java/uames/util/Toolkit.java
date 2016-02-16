package uames.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;

import com.jfinal.core.Controller;

import net.sf.json.JSONObject;
import uames.po.User;
import uames.service.IUser;
import uames.service.impl.UserImpl;
import uames.vo.UserVo;

public class Toolkit {
    private Controller ctrl;
    private Browse browse;
    private UserVo user;

    public Toolkit(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public String getSslHost() {
        return ctrl.getRequest().getHeader("X-ssl") != null ? ("https://" + ctrl.getRequest().getServerName()) : "";
    }
    public String getUnSslHost() {
        return ctrl.getRequest().getHeader("X-ssl") != null ? ("http://" + ctrl.getRequest().getServerName()) +"/" : "";
    }
    public String getUnSslHost2() {
        return "http://" + ctrl.getRequest().getServerName() +"/";
    }
    
    /**
     * 设置COOKIE <param name="cookieKey">COOKIE名称</param> <param
     * name="cookieValue">COOKIE值</param>
     */
    public void setCookie(String cookieKey, String cookieValue, String path) {
        Cookie cookie = new Cookie(cookieKey, cookieValue);
        cookie.setPath(path == null ? "/" : path);
        ctrl.getResponse().addCookie(cookie);
    }

    /**
     * 设置COOKIE <param name="cookieKey">COOKIE名称</param>
     */
    public String getCookie(String cookieKey) {
        Cookie[] cookies = ctrl.getRequest().getCookies();
        String str = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieKey.equals(cookie.getName())) {
                    str = cookie.getValue();
                    break;
                }
            }
        }
        return str;
    }

    public String makeBrowseId() {
        Long time = new Date().getTime();
        String str = UamesUtil.getRandStr();
        return ParseMD5.parseStrToMd5L32(str+time.toString());
    }
    
    public Browse getBrowse() {
        if (browse == null) {
            String str = getCookie("aucn-browse-id");
            if (str.isEmpty()) {
                 setBrowse(UamesUtil.getGlobalID());
            } else {
                browse = (Browse) JSONObject.toBean(JSONObject.fromObject(JedisUtil.get(str)), Browse.class);
                if (browse == null) {
                    setBrowse(str);
                }
            }
        }
        return browse;
    }
    
    private void setBrowse(String key) {
        browse = new Browse();
        browse.setId(key);
        saveBrowse();
        setCookie("aucn-browse-id", String.valueOf(browse.getId()), null);
    }
    
    public void saveBrowse() {
        JedisUtil.put(String.valueOf(browse.getId()), UamesUtil.getJSONStringFromObject(getBrowse()));
    }
    /**
     * ip变更后清空会话
     */
    public void setNewBrowse() {
        logout(getUser().getPo());
        JedisUtil.delete(browse.getId());;
        setBrowse(UamesUtil.getGlobalID());
    }

    public Browse getBrowse(String ip) {
        if (browse == null) {
            String str = ip;
            if (str.isEmpty()) {
                 setBrowse(UamesUtil.getGlobalID());
            } else {
                browse = (Browse) JSONObject.toBean(JSONObject.fromObject(JedisUtil.get(str)), Browse.class);
                if (browse == null) {
                    setBrowse(str,ip);
                }
            }
        }
        return browse;
    }
    private void setBrowse(String key,String ip) {
        browse = new Browse();
        browse.setId(key);
        saveBrowse(ip);
    }
    public void saveBrowse(String ip) {
        setCookie("aucn-browse-id", String.valueOf(browse.getId()), null);
        JedisUtil.put(ip, UamesUtil.getJSONStringFromObject(getBrowse()));
    }

    /**
     * 注销登录
     */
    public void logout(User u) {
        IUser p = new UserImpl();
        u.setIs_login(0);
        if(u.getAccount()!=null){
        	p.saveOrUpdate(u);
        }
        getBrowse().setUserID(-1);
        saveBrowse();
    }
    
    public String getAccoutn(){
    	return getUser().getPo().getAccount();
    }
    
    public String getNickName(){
    	return getUser().getPo().getNick_name();
    }
    
    public boolean getIsLogin() {
        return getBrowse().getUserID() > 0;
    }
    
    public void setAuthCode(String code) {
        getBrowse().setAuthCode(code);
        getBrowse().setAuthCodeLife(new Date());
        saveBrowse();
    }
    public void setIconCode(String code) {
        getBrowse().setIconCode(code);
        getBrowse().setIconCodeLife(new Date());
        saveBrowse();
    }
    
    public void setAucnUrl(String aucn_url){
        getBrowse().setAucn_url(aucn_url);
        saveBrowse();
    }
    public void setAucnAdminUrl(String admin_url){
        getBrowse().setAdmin_url(admin_url);
        saveBrowse();
    }

    public String getAuthCode() {
        return new Date().getTime() < getBrowse().getAuthCodeLife().getTime() + 10 * 60 * 1000 ? getBrowse().getAuthCode() : "";
    }
    public String getIconCode() {
        return new Date().getTime() < getBrowse().getIconCodeLife().getTime() + 10 * 60 * 1000 ? getBrowse().getIconCode() : "";
    }
    
    public String getWebRoot() {
        return ctrl.getSession().getServletContext().getRealPath("/");
    }

    public UserVo getUser() {
        if (!UamesUtil.IsNullOrWhiteSpace(getBrowse().getId()) && user == null) {
            IUser userSvc = new UserImpl();
            user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
        }
        return user;
    }
    
    public String getGender()
    {
    	String gender="";
    	if (!UamesUtil.IsNullOrWhiteSpace(getBrowse().getId())) {
    		IUser userSvc = new UserImpl();
    		user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
    		if(user!=null && user.getPo()!=null){
    			switch(user.getPo().getGender()){
    			case 0:
    				gender="未知";
    				break;
    			case 1:
    				gender="男";
    				break;
    			case 2:
    				gender="女";
    				break;    
    			default:
    				gender="未知";
    				break;
    			}
    		}
    	}
    	return gender;	
    }
    
   

    public Integer getTitle(){
        Integer title=0;
        try {
            if (!UamesUtil.IsNullOrWhiteSpace(getBrowse().getId())) {
                IUser userSvc = new UserImpl();
                user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
                if(user!=null){
                    if(!UamesUtil.IsNullOrWhiteSpace(user.getTitle()))
                        title=1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }
    
    public String getTdPwd(){
        String tdpwd="";
        try {
            if (!UamesUtil.IsNullOrWhiteSpace(getBrowse().getId())) {
                IUser userSvc = new UserImpl();
                user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
                if(user!=null && user.getPo()!=null){
                    tdpwd = user.getPo().getTdpwd();   
                }
            }
        } catch (Exception e) {
               e.printStackTrace();
        }

        return tdpwd;
    }    
    /**
     * 时间转换
     * @param date
     * @param format
     * @return
     */
    public String getSimpleDateFormat(Long date,String format){
    	SimpleDateFormat sdate = new SimpleDateFormat();
    	if(format.toLowerCase()=="yyyy-MM-dd")
    		sdate=new SimpleDateFormat("yyyy-MM-dd");
    	else if(format.toLowerCase()=="yyyy-MM-dd HH:mm:ss")
    		sdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	else
    		sdate=new SimpleDateFormat("");
    	return sdate.format(date);
    }    
    
    public void setUser(UserVo u) {
        
    }

	/**
	 * 总投资
	 * 
	 * @return
	 */
	public String getTotalInvest() {
		Double reval = 0.0;
		String s_reval ="";
		String s_total = "";
		Integer fontsize = 40;
		try {
			IUser userSvc = new UserImpl();
			user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
			if (user != null && user.getPo() != null) {
				reval = user.getPo().getAmount();
			}
	         s_reval = UamesUtil.getStrFormat(reval,2);
	            
			if(reval < 10000)
			    fontsize = 40;
			else if(reval > 10000  && reval <1000000)
			    fontsize = 30;
			else if(reval > 1000000  && reval <100000000)
                fontsize = 25;
			else
			    fontsize = 20;
		} catch (Exception e) {
			e.printStackTrace();
		}

		s_total="  <span class=\"num\" style=\"font-size:"+fontsize+"px;\">"+s_reval+"</span>";
		return s_total;
	}
	
	/**
	 * 总收益
	 * 
	 * @return
	 */
	public String getTotalProfit() {
		Double reval = 0.0;
		String s_reval ="";
		String s_total = "";
		Integer fontsize = 40;
		try {
			IUser userSvc = new UserImpl();
			user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
			if (user != null && user.getPo() != null) {
				reval = user.getPo().getTotal_yield();
			}
			s_reval = UamesUtil.getStrFormat(reval,2);
			if(reval < 10000)
	                fontsize = 40;
	            else if(reval > 10000  && reval <1000000)
	                fontsize = 30;
	            else if(reval > 1000000  && reval <100000000)
	                fontsize = 25;
	            else
	                fontsize = 20;
		} catch (Exception e) {
			e.printStackTrace();
		}
		  s_total="  <span class=\"num\" style=\"font-size:"+fontsize+"px;\">"+s_reval+"</span>";
		return s_total;
	}
   /**
    * 藏金数
    * @return
    */
	public String getTotalGold(){
		Double reval = 0.0;
        String s_total = "";
        Integer fontsize = 40;	
        String s_reval ="";
		try {
			IUser userSvc = new UserImpl();
			user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
			if (user != null && user.getPo() != null) {
				reval = user.getPo().getCollection_gold();
			}
			s_reval = UamesUtil.getStrFormat1(reval,3);
            if(reval < 10000)
                fontsize = 40;
            else if(reval > 10000  && reval <1000000)
                fontsize = 30;
            else if(reval > 1000000  && reval <100000000)
                fontsize = 25;
            else
                fontsize = 20;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 s_total="  <span class=\"num\" style=\"font-size:"+fontsize+"px;\">"+s_reval+"</span>";
		return s_total;
	}
	/**
     * 积分（黄金币）
     * @return
     */
    public String getScore(){
    	Long score=Long.valueOf(0);
        String s_total = "";
        String s_reval ="";
        Integer fontsize = 40;
    	if (!UamesUtil.IsNullOrWhiteSpace(getBrowse().getId())) {
    		IUser userSvc = new UserImpl();
    		user = new UserVo(userSvc.getOne(getBrowse().getUserID()));
    		if(user!=null && user.getPo()!=null){
    			score = user.getPo().getScore();
    		}
    		s_reval = UamesUtil.getStrFormat(score,0);
    		if(score < 10000)
    		    fontsize = 40;
    		else if(score > 10000  && score <1000000)
    		    fontsize = 30;
    		else if(score > 1000000  && score <100000000)
                fontsize = 25;
            else
                fontsize = 20;
    	}
    	s_total="  <span class=\"num\" style=\"font-size:"+fontsize+"px;\">"+s_reval+"</span>";
    	return s_total;
    }
    
    /**
     * 上午1、中午2、下午3、晚上4
     */
    public String getNowTime(){
        String t="0";
        SimpleDateFormat sdate = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(sdate.format(new Date()));
        if(hour>=0 && hour<=6 || hour<=24 && hour>=18){
            t="晚上";
        }else if(hour<=18 && hour>=14){
            t="下午";
        }else if(hour<=14 && hour>=12){
            t="中午";
        }else{
            t="上午";
        }
        return t;
    }

    public Browse getAdBrowse() {
        if (browse == null) {
            String str = getCookie("aucn-admin-browse-id");
            if (str.isEmpty()) {
                setAdBrowse(UamesUtil.getGlobalID());
            } else {
                browse = (Browse) JSONObject.toBean(JSONObject.fromObject(JedisUtil.get(str)), Browse.class);
                if (browse == null) {
                    setAdBrowse(str);
                }
            }
        }
        return browse;
    }
     
    private void setAdBrowse(String key) {
        browse = new Browse();
        browse.setAdmin_id(key);
        saveAdBrowse();
        setCookie("aucn-admin-browse-id", String.valueOf(browse.getAdmin_id()), null);
    }
    
    public void saveAdBrowse() {
        JedisUtil.put(String.valueOf(browse.getAdmin_id()), UamesUtil.getJSONStringFromObject(getAdBrowse()));
    }
}
