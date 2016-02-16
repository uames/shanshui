package uames.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import uames.po.User;
import uames.service.IUser;
import uames.util.PageUtil;
import uames.util.SetValueFromRecord;

public class UserImpl extends BaseImpl<User> implements IUser {

    public UserImpl() {
        this.tableName = "au_user"; // 需要操作的数据库表
    }

    @Override
    public User createPo() {
        return new User();
    }

    @Override
	public User getByAccount(Map<String, String>_where) {
        User user = new User();
        try {
            StringBuilder s_where = new StringBuilder();
            String where = "";
            String sql = "";
            Integer i = 0;
            for (Map.Entry<String, String> entry : _where.entrySet()) {
                if(i>0){
                    s_where.append(" AND ");
                }
                s_where.append(" " + entry.getKey() + entry.getValue());
                i++;
            }
            if(s_where.length()<1){
                where  = null;
            }else{
                where = s_where.toString();
            }
            if(where != null)
                sql = "select *from " + tableName +" where " + where;
            else
                sql = "select *from " + tableName;
            Record record = Db.findFirst(sql);
            if(record!=null)
                SetValueFromRecord.copyProtis(user, record);
            else
                user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getById(String id) {
        User user = new User();
        try {
            String sql = "select *from " + tableName +" where  id = '" + id +"'"; 
            Record record = Db.findFirst(sql);
            if(record!=null)
                SetValueFromRecord.copyProtis(user, record);
            else
                user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public User getByBankAccount(String bankaccount,String account){
        User user = new User();
        try {
            String sql = "select *from " + tableName +" where  bank_account = '" + bankaccount +"' AND account <> '" + account +"'"; 
            Record record = Db.findFirst(sql);
            if(record!=null)
                SetValueFromRecord.copyProtis(user, record);
            else
                user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public User getByIdentification(String identification, String account) {
        User user = new User();
        try {
            String sql = "select *from " + tableName +" where  identification = '" + identification +"' AND account <> '" + account +"'";
            Record record = Db.findFirst(sql);
            if(record!=null)
                SetValueFromRecord.copyProtis(user, record);
            else
                user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public User getByEmail(String email, String id) {
        User user = new User();
        try {
            String sql = "select *from " + tableName +" where  email = '" + email +"' AND id <> '" + id +"'";
            Record record = Db.findFirst(sql);
            if(record!=null)
                SetValueFromRecord.copyProtis(user, record);
            else
                user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public PageUtil<User> getRecentList(Map<String, String> where,Integer pNu, Integer pSize) {
        String columns ="u.*,b.name as bank_name,(select name from au_user where id=u.referee_id) as referee_name from au_user u LEFT JOIN dict b on u.bank_id = b.id ";
        return getList(where,columns, pNu, pSize);
    }
    public PageUtil<User> getList(Map<String, String> t_where, String columns , Integer pNu, Integer pSize) {
        try{
            String where ="";
            String _where = "";
            StringBuilder s_where = new StringBuilder();
            StringBuilder _s_where = new StringBuilder();
            Integer i=0;
            for (Map.Entry<String, String> entry : t_where.entrySet()) {
                if(i>0){
                    s_where.append(" AND ");
                    _s_where.append(" AND ");
                }
                if(entry.getValue()!=null){
                    s_where.append(" " + entry.getKey() + entry.getValue());
                    _s_where.append(" u." + entry.getKey() + entry.getValue());
                    i++;
                }
            }
            if(s_where.length()<1){
                where  = null;
                _where= null;
            }else{
                where = s_where.toString();
                _where= _s_where.toString();
            }
            total = count(where);
            if (pSize != null) {
                this.pSize = pSize;
            }
            else
                this.pSize = Integer.valueOf(total.toString());
            if(total>0)
                pCount = Integer.valueOf(String.valueOf(total / this.pSize + (total % this.pSize > 0 ? 1 : 0)));
            else
                pCount = new Integer(total.toString());
            if(pSize!=null)
                this.pNu = pNu == null ? 1 : (pCount < pNu ? pCount : pNu);
            page = new PageUtil<User>();
            if( this.pNu!=null && this.pNu>0)
                page.setList(queryBySql(_where, columns," order by u.add_time asc ", (this.pNu - 1) * this.pSize, this.pSize));
            else
                page.setList(queryBySql(_where, columns," order by u.add_time asc ", 0, this.pSize));
            page.setCount(total);
            page.setPagecount(pCount);
            page.setPage(this.pNu);
            page.setPagesize(Long.valueOf(this.pSize.toString()));
            page.setStatus(1);
        }catch(Exception e){
            e.printStackTrace();
            page.setStatus(0);
        }

        return page;
    }
    public Long count(String where) {
        where = where == null ? "" : " WHERE " + where;
        List<Record> list = Db.find("SELECT count(*) _count FROM " + tableName + " u "+where);
        return list.get(0).getLong("_count");
    }
    
    @Override
    public List<User> queryBySql(String where, String columns,String orderby, Integer start, Integer count) {
        try {
            StringBuffer buffer = new StringBuffer();
            if (columns == null) {
                buffer.append("select * from " + this.tableName);
            } else {
                buffer.append("select " + columns);
            }
            if (where != null) {
                buffer.append(" where " + where);
            }
            if(orderby!=null)
                buffer.append(orderby);
            
            if (count != null) {
                if (start != null) {
                    buffer.append(" limit " + start + ", " + count);
                } else {
                    buffer.append(" limit " + count);
                }
            }
            List<Record> list = Db.find(buffer.toString());
            List<User> vos = new ArrayList<User>();
            for (Record record : list) {
                User obj = createPo();
                SetValueFromRecord.copyProtis(obj, record);
                vos.add(obj);
            }
            return vos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public String getNickName() {
	    String str="";
	    Integer flag=1;
	    String randomStr=getRandStr();
	 
	    User u = getUser("nick_name",randomStr);
	    do{
		    if(u!=null)
		    {
		    	randomStr=getRandStr();
		    	u = getUser("nick_name",randomStr);
		    }
		    else{
		    	str = randomStr;
		    	flag=0;
		    }
	    }while(flag==1);
	    return str;
	}
	
	/**
	 * ‘0-9 + a-z’ 随机码
	 * @return String
	 */
	private String getRandStr()
	{
		StringBuffer array = new StringBuffer();
		for (int i = 0; i <= 9; i++) {
			array.append(i);
		}
		for (int i = 'a'; i <= 'z'; i++) {
			array.append((char) i);
		}
		int length = array.length();
		int n = 7;
		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			char c = array.charAt((int) (Math.random() * length));
			str.append(c);
		}
		return "zj_" + str.toString();		
	}

	@Override
	public User getUser(String fieldName, String where) {
        List<User> l = queryBySql(fieldName+ "='" + where + "'", null, null, null, null);
        return l.size() > 0 ? l.get(0) : null;
	}
	/**
	 * 用户登录成功后，更新登录次数、最后次登录时间、ip地址
	 */
	@Override
	public void upUser(User user) {

		Date time = new Date();
		int times = user.getLogin_times();
		user.setLogin_times(times+1);
		user.setLast_login_time(time.getTime());
		saveOrUpdate(user);
	}
	
	public String getFormatMoney(Double money,int type){
	    String result = null;
	    Double baiyi = new Double("9999999999").doubleValue();
	    if(money > baiyi){
	        money = (money/(double) 100000000);
            result = money.toString().substring(0,6);
            if(type == 1)
                result += "/亿";
            else
                result += "亿";
	    }else if(money > (double)999999){
	        money = (money/(double) 10000);
            result = money.toString().substring(0,6);
            if(type == 1)
                result += "/万";
            else
                result += "万";
	    }else{
	        result = money.toString();
            if(type == 1)
                result += "/";
            else
                result += "";
	    }
        return result;
	}
}
