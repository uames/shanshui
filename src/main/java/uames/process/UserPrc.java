package uames.process;

import uames.po.User;
import uames.service.IUser;
import uames.service.impl.UserImpl;
import uames.util.Toolkit;

public class UserPrc {
    public String msg;
    private User user;
    public IUser iuser = new UserImpl();
    public Toolkit tk;
    /**
     * 构造（初始 user对象）
     * @param u
     */
    public UserPrc(User u) {
        if (u != null) {
            user = u;
            iuser = new UserImpl();
        } else {
            msg = "用户不存在";
        }
    }
    public UserPrc(){
        iuser = new UserImpl();
    }
}
