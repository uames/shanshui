package uames.service;

import java.util.List;

import uames.po.Base;

public interface IBase<T extends Base> {

    public T getOne(long id);

    public T createPo();

    public void deleteById(Long id);

    public Long saveOrUpdate(T t);

    public void Login(T t);

    /*
     * 根据sql根性数据库
     */
    public Integer updateBySql(String sql);

    public Integer updateBySql(String sql, Object... param);

    public List<T> queryBySql(String where, String columns,String orderby, Integer start, Integer count);
}
