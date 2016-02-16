package uames.po;

/**
 * 系统设置
 * 
 * @author Cindy
 * 
 */
public class SystemSetting extends Base {
	private String web_title;
	private String keyword;
	private String description;
	private String domain;
	private String root_path;
	private String img_host;
	private Double today_price;
	private Integer bool_sql_log;
	private Long score_register;
	private Long score_share;
	private Long score_recommend;
	private Double score_ratio_money;           // 购买金额
	private Long score_ratio_score;             // 赠送积分
    private Double recommand_score_ratio_money;   // 推荐用户购买金额
    private Long recommand_score_ratio_score;   // 推荐用户购买赠送积分	
	private Long score_login;
	private String orderid_prefix;
	private Double historical_annual_rate;
	private Integer tip_register_sms;
	private Integer tip_register_email; // 注册提醒：邮箱
	private Integer tip_register_message; // 注册提醒：站内信
	private Integer tip_order_sms; // 下单提醒：短信
	private Integer tip_order_email; // 下单提醒：邮件
	private Integer tip_order_message; // 下单提醒：站内信
	private Integer tip_pay_sms; // 支付提醒：短信
	private Integer tip_pay_email; // 支付提醒：邮件
	private Integer tip_pay_message; // 支付提醒：站内信
	private Integer tip_order_expired_sms; // 订单过期提醒：短信
	private Integer tip_order_expired_email;// 订单过期提醒：邮件
	private Integer tip_order_expired_message; // 订单过期提醒：站内信
	private Integer tip_settlement_sms; // 结算提醒：短信
	private Integer tip_settlement_email; // 结算提醒：邮件
	private Integer tip_settlement_message; // 结算提醒：站内信
	private Integer tip_withdrawal_sms; // 提现提醒：短信
	private Integer tip_withdrawal_email; // 提现提醒：邮件
	private Integer tip_withdrawal_message; // 提现提醒：邮件
	private String tip_update_goldprice_mobiles; // 提现提醒：站内信
	private Integer investment_ratio_money;    // 单笔投资金额
	private Integer investment_ratio_exp;      // 经验值
	private String tip_check_goldprice_mobiles;    //  审核金价提醒手机号码
 	private Integer close_order_days;              // 订单过期时间
	
 	private Integer value_days;       // T+1 起息日	
 	
 	private Integer tip_coninvest_sms;        // 续投：短信
 	private Integer tip_coninvest_email;      // 续投：邮箱
 	private Integer tip_coninvest_message;    // 续投：站内信
 	private Integer tip_coninvest_push;       // 续投：百度推送
 	
	public Integer getValue_days() {
        return value_days;
    }

    public void setValue_days(Integer value_days) {
        this.value_days = value_days;
    }

    public Integer getClose_order_days() {
        return close_order_days;
    }

    public void setClose_order_days(Integer close_order_days) {
        this.close_order_days = close_order_days;
    }

    public String getWeb_title() {
		return web_title;
	}

	public void setWeb_title(String web_title) {
		this.web_title = web_title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getRoot_path() {
		return root_path;
	}

	public void setRoot_path(String root_path) {
		this.root_path = root_path;
	}

	public String getImg_host() {
		return img_host;
	}

	public void setImg_host(String img_host) {
		this.img_host = img_host;
	}

	public Double getToday_price() {
		return today_price;
	}

	public void setToday_price(Double today_price) {
		this.today_price = today_price;
	}

	public Integer getBool_sql_log() {
		return bool_sql_log;
	}

	public void setBool_sql_log(Integer bool_sql_log) {
		this.bool_sql_log = bool_sql_log;
	}

	public Long getScore_register() {
		return score_register;
	}

	public void setScore_register(Long score_register) {
		this.score_register = score_register;
	}

	public Long getScore_share() {
		return score_share;
	}

	public void setScore_share(Long score_share) {
		this.score_share = score_share;
	}

	public Long getScore_recommend() {
		return score_recommend;
	}

	public void setScore_recommend(Long score_recommend) {
		this.score_recommend = score_recommend;
	}

	public Double getScore_ratio_money() {
		return score_ratio_money;
	}

	public void setScore_ratio_money(Double score_ratio_money) {
		this.score_ratio_money = score_ratio_money;
	}

	public Long getScore_ratio_score() {
		return score_ratio_score;
	}

	public void setScore_ratio_score(Long score_ratio_score) {
		this.score_ratio_score = score_ratio_score;
	}

	public Long getScore_login() {
		return score_login;
	}

	public void setScore_login(Long score_login) {
		this.score_login = score_login;
	}

	public String getOrderid_prefix() {
		return orderid_prefix;
	}

	public void setOrderid_prefix(String orderid_prefix) {
		this.orderid_prefix = orderid_prefix;
	}

	public Double getHistorical_annual_rate() {
		return historical_annual_rate;
	}

	public void setHistorical_annual_rate(Double historical_annual_rate) {
		this.historical_annual_rate = historical_annual_rate;
	}

	public Integer getTip_register_sms() {
		return tip_register_sms;
	}

	public void setTip_register_sms(Integer tip_register_sms) {
		this.tip_register_sms = tip_register_sms;
	}

	public Integer getTip_register_email() {
		return tip_register_email;
	}

	public void setTip_register_email(Integer tip_register_email) {
		this.tip_register_email = tip_register_email;
	}

	public Integer getTip_register_message() {
		return tip_register_message;
	}

	public void setTip_register_message(Integer tip_register_message) {
		this.tip_register_message = tip_register_message;
	}

	public Integer getTip_order_sms() {
		return tip_order_sms;
	}

	public void setTip_order_sms(Integer tip_order_sms) {
		this.tip_order_sms = tip_order_sms;
	}

	public Integer getTip_order_email() {
		return tip_order_email;
	}

	public void setTip_order_email(Integer tip_order_email) {
		this.tip_order_email = tip_order_email;
	}

	public Integer getTip_order_message() {
		return tip_order_message;
	}

	public void setTip_order_message(Integer tip_order_message) {
		this.tip_order_message = tip_order_message;
	}

	public Integer getTip_pay_sms() {
		return tip_pay_sms;
	}

	public void setTip_pay_sms(Integer tip_pay_sms) {
		this.tip_pay_sms = tip_pay_sms;
	}

	public Integer getTip_pay_email() {
		return tip_pay_email;
	}

	public void setTip_pay_email(Integer tip_pay_email) {
		this.tip_pay_email = tip_pay_email;
	}

	public Integer getTip_pay_message() {
		return tip_pay_message;
	}

	public void setTip_pay_message(Integer tip_pay_message) {
		this.tip_pay_message = tip_pay_message;
	}

	public Integer getTip_order_expired_sms() {
		return tip_order_expired_sms;
	}

	public void setTip_order_expired_sms(Integer tip_order_expired_sms) {
		this.tip_order_expired_sms = tip_order_expired_sms;
	}

	public Integer getTip_order_expired_email() {
		return tip_order_expired_email;
	}

	public void setTip_order_expired_email(Integer tip_order_expired_email) {
		this.tip_order_expired_email = tip_order_expired_email;
	}

	public Integer getTip_order_expired_message() {
		return tip_order_expired_message;
	}

	public void setTip_order_expired_message(Integer tip_order_expired_message) {
		this.tip_order_expired_message = tip_order_expired_message;
	}

	public Integer getTip_settlement_sms() {
		return tip_settlement_sms;
	}

	public void setTip_settlement_sms(Integer tip_settlement_sms) {
		this.tip_settlement_sms = tip_settlement_sms;
	}

	public Integer getTip_settlement_email() {
		return tip_settlement_email;
	}

	public void setTip_settlement_email(Integer tip_settlement_email) {
		this.tip_settlement_email = tip_settlement_email;
	}

	public Integer getTip_settlement_message() {
		return tip_settlement_message;
	}

	public void setTip_settlement_message(Integer tip_settlement_message) {
		this.tip_settlement_message = tip_settlement_message;
	}

	public Integer getTip_withdrawal_sms() {
		return tip_withdrawal_sms;
	}

	public void setTip_withdrawal_sms(Integer tip_withdrawal_sms) {
		this.tip_withdrawal_sms = tip_withdrawal_sms;
	}

	public Integer getTip_withdrawal_email() {
		return tip_withdrawal_email;
	}

	public void setTip_withdrawal_email(Integer tip_withdrawal_email) {
		this.tip_withdrawal_email = tip_withdrawal_email;
	}

	public Integer getTip_withdrawal_message() {
		return tip_withdrawal_message;
	}

	public void setTip_withdrawal_message(Integer tip_withdrawal_message) {
		this.tip_withdrawal_message = tip_withdrawal_message;
	}

	public String getTip_update_goldprice_mobiles() {
		return tip_update_goldprice_mobiles;
	}

	public void setTip_update_goldprice_mobiles(
	        String tip_update_goldprice_mobiles) {
		this.tip_update_goldprice_mobiles = tip_update_goldprice_mobiles;
	}

    public Double getRecommand_score_ratio_money() {
        return recommand_score_ratio_money;
    }

    public void setRecommand_score_ratio_money(Double recommand_score_ratio_money) {
        this.recommand_score_ratio_money = recommand_score_ratio_money;
    }

    public Long getRecommand_score_ratio_score() {
        return recommand_score_ratio_score;
    }

    public void setRecommand_score_ratio_score(Long recommand_score_ratio_score) {
        this.recommand_score_ratio_score = recommand_score_ratio_score;
    }

    public Integer getInvestment_ratio_money() {
        return investment_ratio_money;
    }

    public void setInvestment_ratio_money(Integer investment_ratio_money) {
        this.investment_ratio_money = investment_ratio_money;
    }

    public Integer getInvestment_ratio_exp() {
        return investment_ratio_exp;
    }

    public void setInvestment_ratio_exp(Integer investment_ratio_exp) {
        this.investment_ratio_exp = investment_ratio_exp;
    }

    public String getTip_check_goldprice_mobiles() {
        return tip_check_goldprice_mobiles;
    }

    public void setTip_check_goldprice_mobiles(String tip_check_goldprice_mobiles) {
        this.tip_check_goldprice_mobiles = tip_check_goldprice_mobiles;
    }

    public Integer getTip_coninvest_sms() {
        return tip_coninvest_sms;
    }

    public void setTip_coninvest_sms(Integer tip_coninvest_sms) {
        this.tip_coninvest_sms = tip_coninvest_sms;
    }

    public Integer getTip_coninvest_email() {
        return tip_coninvest_email;
    }

    public void setTip_coninvest_email(Integer tip_coninvest_email) {
        this.tip_coninvest_email = tip_coninvest_email;
    }

    public Integer getTip_coninvest_message() {
        return tip_coninvest_message;
    }

    public void setTip_coninvest_message(Integer tip_coninvest_message) {
        this.tip_coninvest_message = tip_coninvest_message;
    }

    public Integer getTip_coninvest_push() {
        return tip_coninvest_push;
    }

    public void setTip_coninvest_push(Integer tip_coninvest_push) {
        this.tip_coninvest_push = tip_coninvest_push;
    }

 
}
