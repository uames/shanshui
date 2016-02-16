package uames.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uames.exception.VoException;
import uames.po.User;
import uames.service.impl.UserImpl;
import uames.util.UamesUtil;

public class UserVo extends BaseVo<User> {

    private Integer loginStep = 0;
    private String loginName;
    private String loginPwd;
    
    public UserVo(User t) {
        super(t);
    }

    public UserVo() {
        super();
        setPo(new User());
    }

    public Integer getLoginStep() {
        return loginStep;
    }
    public String getTitle(){
        return getPo().getTitle();
    }
    
    /**
     * 业务员（推荐人）
     * 
     * @return
     */
    public String getRefereeRealname() {
        String name = "";
        try {
            User user = getPo();
            if (user.getReferee_id() != null && user.getReferee_id() > 0) {
                User re_user = new UserImpl().getOne(user.getReferee_id());
                if (re_user != null && re_user.getReal_name() != null)
                    name = re_user.getReal_name();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 推荐人账号
     * @return
     */
    public String getRefereeAccount() {
        String name = "";
        try {
            User user = getPo();
            if (user.getReferee_id() != null && user.getReferee_id() > 0) {
                User re_user = new UserImpl().getOne(user.getReferee_id());
                if (re_user != null && re_user.getAccount() != null)
                    name = re_user.getAccount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

   
    
    public static List<UserVo> createList(List<User> ls) {
        List<UserVo> result = new ArrayList<UserVo>();
        if (ls != null) {
            for (User g : ls) {
                result.add(new UserVo(g));
            }
        }
        return result;
    }

    public String getNick_name(){
        String name = getPo().getNick_name();
        if(name!=null && name.length()>12){
            name = name.substring(0,11) + "...";
        }
        return name;
    }
    
    
    /**
     * 注册判断账号是否存在
     * @param val
     * @throws VoException
     */
    public void setAccount(String account) throws VoException {
        UserImpl impl = new UserImpl();
        Map<String, String> where = new HashMap<String, String>();
        where.put("account = ", account);
        User user = impl.getByAccount(where);
        if (user != null) {
            VoException t = new VoException("账号已存在！");
            StackTraceElement[] trace = new StackTraceElement[] { new StackTraceElement("AU_UserVo", "setAccount", "AU_UserVo.java", 75) };
            // sets the stack trace elements
            t.setStackTrace(trace);
            throw t;
        }
        getPo().setAccount(account);
    }

    /**
     * 登录过程
     * @param val
     */
    public void setPassword(String val) throws VoException {
        loginPwd = val;
        auth();
    }
    
    /**
     * 登录过程
     * @param val
     */
    public void setLoginname(String val) throws VoException {
        loginName = val;
        auth();
    }
    
    private void auth() throws VoException {

        loginStep++;
        if (loginStep != 2) {
            return;
        }
        if (UamesUtil.IsNullOrWhiteSpace(loginName)) {
            VoException t = new VoException("账号为空！");
            t.setStackTrace(new StackTraceElement[] { new StackTraceElement("AU_UserVo", "setAccount", "AU_UserVo.java", 125) });
            throw t;
        }
        if (UamesUtil.IsNullOrWhiteSpace(loginPwd)) {
            VoException t = new VoException("密码为空！");
            t.setStackTrace(new StackTraceElement[] { new StackTraceElement("AU_UserVo", "setAccount", "AU_UserVo.java", 130) });
            throw t;
        }
        UserImpl impl = new UserImpl();
        Map<String, String> where = new HashMap<String, String>();
        where.put("account = ", loginName);
        User user = impl.getByAccount(where);
        if (user == null) {
            VoException t = new VoException("账号不存在！");
            t.setStackTrace(new StackTraceElement[] { new StackTraceElement("AU_UserVo", "setAccount", "AU_UserVo.java", 139) });
            throw t;
        } else if (!user.getPassword().equals(loginPwd)) {
            VoException t = new VoException("密码不正确！");
            t.setStackTrace(new StackTraceElement[] { new StackTraceElement("AU_UserVo", "setAccount", "AU_UserVo.java", 143) });
            throw t;
        }
        setPo(user);
    }
    
    
    
}
