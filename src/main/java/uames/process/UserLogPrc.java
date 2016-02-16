package uames.process;

import java.util.Date;

import uames.po.User;
import uames.po.UserLog;
import uames.service.IUserLog;
import uames.service.impl.UserLogImpl;

public class UserLogPrc {
    public String msg;
    private User user;
    /**
     * 构造（初始 user对象）
     * @param u
     */
    public UserLogPrc(User u) {
        if (u != null) {
            user = u;
        } else {
            msg = "用户不存在";
        }
    }
    
    /**
     * 保存日志
     * type  1下单；2支付成功；3修改登录密码；4修改交易密码；5修改个人信息；
     *       6删除待支付订单；7删除推荐的好友列表；8删除‘我的资金’流程；9删除‘我的黄金币’； 10网银支付;11 登录日志;12 安全退出
     * @param type
     * @param description
     */
    public String addUserLog(Integer type,String description){
        try {
            IUserLog svc = new UserLogImpl();
            UserLog po = new UserLog();
            po.setUser_id(user.getId());
            po.setType(type);
            po.setDescription(description);
            po.setAdd_time(new Date().getTime());
            svc.saveOrUpdate(po); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
