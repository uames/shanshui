package uames.util;

import java.util.Date;

public class Browse {
    private String id;
    private String admin_id;
    private long userID;
    private String authCode;	//  注册验证码
    private String iconCode;
    private String user;
    private Date authCodeLife;	// 时间
    private Date iconCodeLife;
    private String code;		// 随机码（注册）
    private String refereeid;	// 推荐人id
    private String refereetype;   // 推荐：0；分享：1；
    private String telephone;	// 注册的手机号码
    private String password;	// 密码
    
    private boolean firAccess;  //该浏览器是否为首次访问
    private String ygold;		// 昨日藏金克数
    private String allgold;		// 总的藏金克数
    private Long time;			// 统计藏金时间
    private boolean ifLogout;    // 超过一定时间无操作退出登录
    private Integer fails;      // 登录失败次数
    private Date fail_time;     // 最后次登录失败时间
    private String ip_locked;   // 登录失败禁止的ip地址
    private Date logoutTimeLife;//
    
    private String aucn_url;    // 主站数据库地址
    private String admin_url;   // 后台数据库地址
    private String login_ip;    //登录的ip地址，该地址若有改变则自动退出登录
 
    public String getAdmin_id() {
        return admin_id;
    }
    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    public String getAucn_url() {
        return aucn_url;
    }
    public void setAucn_url(String aucn_url) {
        this.aucn_url = aucn_url;
    }
    public String getAdmin_url() {
        return admin_url;
    }
    public void setAdmin_url(String admin_url) {
        this.admin_url = admin_url;
    }
    public boolean getIfLogout() {
        if(logoutTimeLife != null){
            Long curtime = new Date().getTime();
            Long oldtime = logoutTimeLife.getTime();
            if(oldtime + 10 * 60 * 1000 < curtime){
                ifLogout = true;
            }
        }
        return ifLogout;
    }
    public void setIfLogout(boolean ifLogout) {
        this.ifLogout = ifLogout;
    }
    public Date getLogoutTimeLife() {
        return logoutTimeLife;
    }
    public void setLogoutTimeLife(Date logoutTimeLife) {
        this.logoutTimeLife = logoutTimeLife;
    }
 
 
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getUserID() {
        return userID;
    }
    public void setUserID(long userID) {
        this.userID = userID;
    }
    
    public Integer getFails() {
        return fails;
    }
    public void setFails(Integer fails) {
        this.fails = fails;
    }
    public Date getFail_time() {
        return fail_time;
    }
    public void setFail_time(Date fail_time) {
        this.fail_time = fail_time;
    }
 
    public String getIp_locked() {
        return ip_locked;
    }
    public void setIp_locked(String ip_locked) {
        this.ip_locked = ip_locked;
    }
    /**
     * 验证码10分钟有效
     * @return
     */
    public String getAuthCode() {
    	String _str = null;
    	if(authCodeLife != null){
        	Long curtime = new Date().getTime();
        	Long oldtime = authCodeLife.getTime();

        	if(oldtime + 10 * 60 * 1000 > curtime)
        		_str = authCode;
    	}
        return _str;
    }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    public String getIconCode() {
        String _str = null;
        if(iconCodeLife != null){
            Long curtime = new Date().getTime();
            Long oldtime = iconCodeLife.getTime();

            if(oldtime + 10 * 60 * 1000 > curtime)
                _str = iconCode;
        }
        return _str;
    }
    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }
    public Date getIconCodeLife() {
        return iconCodeLife;
    }
    public void setIconCodeLife(Date iconCodeLife) {
        this.iconCodeLife = iconCodeLife;
    }
    public Date getAuthCodeLife() {
        return authCodeLife;
    }
    public void setAuthCodeLife(Date authCodeLife) {
        this.authCodeLife = authCodeLife;
    }
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRefereeid() {
		return refereeid;
	}
	public void setRefereeid(String refereeid) {
		this.refereeid = refereeid;
	}
	public String getRefereetype() {
        return refereetype;
    }
    public void setRefereetype(String refereetype) {
        this.refereetype = refereetype;
    }
    public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getYgold() {
		return ygold;
	}
	public void setYgold(String ygold) {
		this.ygold = ygold;
	}
	public String getAllgold() {
		return allgold;
	}
	public void setAllgold(String allgold) {
		this.allgold = allgold;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
    public boolean isFirAccess() {
        return firAccess;
    }
    public void setFirAccess(boolean firAccess) {
        this.firAccess = firAccess;
    }
    public String getLogin_ip() {
        return login_ip;
    }
    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }
    
    
}
