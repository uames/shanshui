package uames.po;



public class User extends Base  {
	/**
	 * 用户名（手机号）
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	private String tdpwd;
	private Integer term_start;        // 周期范围 开始
	private Integer term_end;          // 周期范围 结束
	private Double rate_start;         // 年化收益率 开始
	private Double rate_end;           // 年化收益率 结束
	private Double principal_amount;   // 续投的本金比例
	private Integer is_continue;       // 1开启自动续投；0关闭自动续投
	private Long channel_id;           // push
	private String p_uid;              // push
	private Integer login_model;       // 终端：1：安卓;0:ios
	/**
	 * 昵称
	 */
	private String nick_name;
	/**
	 * 姓名
	 */
	private String real_name;
	/**
	 * 推荐人
	 */
	private Long referee_id;
	/**
	 * 推荐人
	 */
	private String referee_name;
	/**
	 * 会员组id
	 */
	private Long group_id;
	/**
	 * 交易密码
	 */
	private String financial_password;
	/**
	 * 性别：默认0；0未知；1男；2女；
	 */
	private Integer gender;
	private String email;
	private String title;              // 称谓
	/**
	 * 身份证号码
	 */
	private String identification;
	private Integer type;  // 0 PC注册；1手机注册;2 手机web
	/**
	 * 历史投资总金额
	 */
	private Double amount;
	/**
	 * 待返还金额
	 */
	private Double watting_return_amout;
	/**
	 * 历史纯收益
	 */
	private Double total_yield;
	/**
	 * 藏金克数
	 */
	private Double collection_gold;

	/**
	 * 可用金额
	 */
	private Double account_free;
	/**
	 * 积分:黄金币
	 */
	private Long score;
	/**
	 * 经验值，判定等级
	 */
	private Long exp;
	private String address;
	private String qq;
	/**
	 * 开户行id
	 */
	private Long bank_id;
	/*
	 * 银行账号
	 */
	private String bank_account;
	private String bank_name;
	private String bank_code;  // 最后次交易的银行编码
	/**
	 * 登录次数
	 */
	private Integer login_times;
	/**
	 * 最后次登录的IP地址
	 */
	private String last_login_ip;
	/**
	 * 最后次登录时间
	 */
	private Long last_login_time;
	// is_checked 1:表示用户完成个人信息填写和设置交易密码（可以认购）；2表示只设置了交易密码（不能认购）;3：表示只完成个人信息填写（不能认购）；null或0：不能认购。
	private Integer is_checked;    
	private Long times;            // 认购次数
	private Integer is_service;    // 1:业务员；0：会员
	private Integer is_login;  // 1为已登录不可以再登录，0为可以登录。
	private Integer email_status;  // 修改登录密码的邮箱验证有效时间
	private String invest_style; //投资风格，用户完成问卷后保存，有“稳健型”和“进取型”两种。
	private String answer_code;  //用户回答的问题的答案序列。
 
	public Integer getIs_continue() {
        return is_continue;
    }
    public void setIs_continue(Integer is_continue) {
        this.is_continue = is_continue;
    }
    public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Long getReferee_id() {
		return referee_id;
	}
	public void setReferee_id(Long referee_id) {
		this.referee_id = referee_id;
	}
	public Long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}
	public String getFinancial_password() {
		return financial_password;
	}
	public void setFinancial_password(String financial_password) {
		this.financial_password = financial_password;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getWatting_return_amout() {
		return watting_return_amout;
	}
	public void setWatting_return_amout(Double watting_return_amout) {
		this.watting_return_amout = watting_return_amout;
	}
	public Double getTotal_yield() {
		return total_yield;
	}
	public void setTotal_yield(Double total_yield) {
		this.total_yield = total_yield;
	}
	public Double getAccount_free() {
		return account_free;
	}
	public void setAccount_free(Double account_free) {
		this.account_free = account_free;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Long getExp() {
		return exp;
	}
	public void setExp(Long exp) {
		this.exp = exp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getLogin_times() {
		return login_times;
	}
	public void setLogin_times(Integer login_times) {
		this.login_times = login_times;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public Long getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Long last_login_time) {
		this.last_login_time = last_login_time;
	}
	public Long getBank_id() {
		return bank_id;
	}
	public void setBank_id(Long bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public Double getCollection_gold() {
		return collection_gold;
	}
	public void setCollection_gold(Double collection_gold) {
		this.collection_gold = collection_gold;
	}
    public String getTdpwd() {
        return tdpwd;
    }
    public void setTdpwd(String tdpwd) {
        this.tdpwd = tdpwd;
    }
    public Integer getIs_checked() {
        return is_checked;
    }
    public void setIs_checked(Integer is_checked) {
        this.is_checked = is_checked;
    }
    public Long getTimes() {
        return times;
    }
    public void setTimes(Long times) {
        this.times = times;
    }
    public Integer getIs_service() {
        return is_service;
    }
    public void setIs_service(Integer is_service) {
        this.is_service = is_service;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBank_name() {
        return bank_name;
    }
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
    public Integer getEmail_status() {
        return email_status;
    }
    public void setEmail_status(Integer email_status) {
        this.email_status = email_status;
    }
    public Integer getIs_login() {
        return is_login;
    }
    public void setIs_login(Integer is_login) {
        this.is_login = is_login;
    }
    public String getReferee_name() {
        return referee_name;
    }
    public void setReferee_name(String referee_name) {
        this.referee_name = referee_name;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getBank_code() {
        return bank_code;
    }
    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInvest_style() {
        return invest_style;
    }
    public void setInvest_style(String invest_style) {
        this.invest_style = invest_style;
    }
    public String getAnswer_code() {
        return answer_code;
    }
    public void setAnswer_code(String answer_code) {
        this.answer_code = answer_code;
    }
    public Integer getTerm_start() {
        return term_start;
    }
    public void setTerm_start(Integer term_start) {
        this.term_start = term_start;
    }
    public Integer getTerm_end() {
        return term_end;
    }
    public void setTerm_end(Integer term_end) {
        this.term_end = term_end;
    }
    public Double getRate_start() {
        return rate_start;
    }
    public void setRate_start(Double rate_start) {
        this.rate_start = rate_start;
    }
    public Double getRate_end() {
        return rate_end;
    }
    public void setRate_end(Double rate_end) {
        this.rate_end = rate_end;
    }
    public Double getPrincipal_amount() {
        return principal_amount;
    }
    public void setPrincipal_amount(Double principal_amount) {
        this.principal_amount = principal_amount;
    }
 
    public Long getChannel_id() {
        return channel_id;
    }
    public void setChannel_id(Long channel_id) {
        this.channel_id = channel_id;
    }
    public String getP_uid() {
        return p_uid;
    }
    public void setP_uid(String p_uid) {
        this.p_uid = p_uid;
    }
    public Integer getLogin_model() {
        return login_model;
    }
    public void setLogin_model(Integer login_model) {
        this.login_model = login_model;
    }
    
}
