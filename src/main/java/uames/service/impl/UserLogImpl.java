package uames.service.impl;

import uames.po.UserLog;
import uames.service.IUserLog;

public class UserLogImpl extends BaseImpl<UserLog> implements IUserLog {
    public UserLogImpl() {
        tableName = "user_log";
    }

    @Override
    public UserLog createPo() {
        return new UserLog();
    }
}