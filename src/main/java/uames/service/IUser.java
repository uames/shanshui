package uames.service;

import java.util.Map;

import uames.po.User;


public interface IUser extends IBase<User> {
	public User getByAccount(Map<String, String>_where);
    public User getByBankAccount(String bankaccount,String account);
    public User getByIdentification(String identification,String account);
    public User getByEmail(String email,String id);
    public User getById(String id);
    
    
    public String getNickName();
    public User getUser(String fieldName, String where);
    /**
     * 用户登录成功后，更新登录次数、最后次登录时间、ip地址
     * @param user
     */
    public void upUser(User user);

    
}
