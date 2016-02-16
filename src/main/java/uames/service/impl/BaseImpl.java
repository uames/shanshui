package uames.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;

import uames.po.Base;
import uames.service.IBase;
import uames.util.PageUtil;
import uames.util.SetValueFromRecord;

public class BaseImpl<T extends Base> implements IBase<T> {
    public Integer pNu;
    public Integer pSize = 8;
    public Integer pCount;
    public Long total;
    public PageUtil<T> page; 
    protected T result;
    protected String tableName;

    public BaseImpl() {
        result = createPo(); // 给Vo对象赋值
    }
    
    @Override
	@SuppressWarnings("unchecked")
    public T createPo() {
        return (T) new Base();
    }

    @Override
	public T getOne(long id) {
        try {
            Record res = Db.findById(tableName, id);
            result = createPo();
            SetValueFromRecord.copyProtis(result, res);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
     * (non-Javadoc) 更具主键删除记录
     */
    @Override
	public void deleteById(Long id) {
        // TODO Auto-generated method stub
        try {
            Db.deleteById(tableName, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc) 根据vo对象插入或者保存对象
     */
    @Override   
    @Before(Tx.class)
	public Long saveOrUpdate(T t) {
        try {
            if (t.getId() != null) { // 如果存在Id，则更新
                Db.update(tableName, SetValueFromRecord.GetRecordFromObj(t));
            } else { // 否则新增
            	Date time = new Date(System.currentTimeMillis());
                t.setAdd_time(time.getTime());
                Record record = SetValueFromRecord.GetRecordFromObj(t);
                Db.save(tableName, "primaryKey", record);
                return record.getLong("primaryKey");
            }
//            System.out.println(121);
//            throw new Exception("pachuyichany");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       return null;
    }

    /*
     * (non-Javadoc) 根据sql语句更新数据库
     */
    @Override
	public Integer updateBySql(String sql) {
        try {
            return Db.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * (non-Javadoc) 根据sql语句和参数更新数据库
     */
    @Override
	public Integer updateBySql(String sql, Object... param) {
        // TODO Auto-generated method stub
        try {
            Db.update(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long count(String where) {
        where = where == null ? "" : " WHERE " + where;
        List<Record> list = Db.find("SELECT count(*) _count FROM " + tableName + where);
        return list.get(0).getLong("_count");
    }
    
    @Override
	public List<T> queryBySql(String where, String columns,String orderby, Integer start, Integer count) {
        // TODO Auto-generated method stub
        try {
            StringBuffer buffer = new StringBuffer();
            if (columns == null) {
                buffer.append("select * from " + this.tableName);
            } else {
                buffer.append("select " + columns + " from " + this.tableName);
            }
            if (where != null) {
                buffer.append(" where " + where);
            }
            if(orderby !=null)
            	buffer.append(" " +  orderby);
            
            if (count != null) {
                if (start != null) {
                    buffer.append(" limit " + start + ", " + count);
                } else {
                    buffer.append(" limit " + count);
                }
            }
            List<Record> list = Db.find(buffer.toString());
            List<T> vos = new ArrayList<T>();
            if(list!=null){
                for (Record record : list) {
                    T obj = createPo();
                    SetValueFromRecord.copyProtis(obj, record);
                    vos.add(obj);
                }  
            }else{
                vos = null;
            }
            return vos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> getList(String where,String orderby, Integer pNu, Integer pSize) {
        total = count(where);
        if (pSize != null) {
            this.pSize = pSize;
        }
        pCount = Integer.valueOf(String.valueOf(total / this.pSize + (total % this.pSize > 0 ? 1 : 0)));
        this.pNu = pNu == null ? 1 : (pCount < pNu ? pCount : pNu);
        return queryBySql(where, null, orderby, (this.pNu - 1) * pSize, pSize);
    }
    
    /**
     * 
     * @param where
     * @param pNu
     * @param pSize
     * @return
     */
    public PageUtil<T> getPgList(String where, String columns, Integer pNu,
            Integer pSize) {
        try {
            total = count(where);
            if (pSize != null) {
                this.pSize = pSize;
            }
            pCount = Integer.valueOf(String.valueOf(total / this.pSize
                    + (total % this.pSize > 0 ? 1 : 0)));
            this.pNu = pNu == null ? 1 : (pCount < pNu ? pCount : pNu);
            page = new PageUtil<T>();
            page.setList(queryBySql(where, columns, null, (this.pNu - 1) * pSize,
                    pSize));
            page.setCount(total);
            page.setPagecount(pCount);
            page.setPage(pNu);
            page.setStatus(1);
        } catch (Exception e) {
            e.printStackTrace();
            page.setStatus(0);
        }

        return page;
    }

    /**
     * 登录
     */
    @Override
	public void Login(T t) {
        // TODO Auto-generated method stub

    }

}
