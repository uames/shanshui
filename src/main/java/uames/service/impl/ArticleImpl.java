package uames.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import uames.po.Article;
import uames.service.IArticle;
import uames.util.PageUtil;
import uames.util.SetValueFromRecord;

public class ArticleImpl  extends BaseImpl<Article> implements IArticle {
    public ArticleImpl() {
        tableName = "article";
    }
    public ArticleImpl(String tablename) {
        tableName = tablename;
    }
    @Override
    public Article createPo() {
        return new Article();
    }
    
	@Override
	public Article getArticleById(Long id) {
		String sql ="select a.*, d.content from article a RIGHT JOIN article_data d on a.id = d.article_id where a.id=" + id;
        Record record = Db.findFirst(sql);
        Article data = new Article();

        SetValueFromRecord.copyProtis(data, record);
        return data;		
	}
	
	public Article getArticMinsort(Long catid){
		String sql ="select a.id from article a where a.cat_id = " +catid +" ORDER BY sort DESC limit 1" ;
        Record record = Db.findFirst(sql);
        Article data = new Article();

        SetValueFromRecord.copyProtis(data, record);
        return data;
	}
	/**
	 * 文章列表
	 * @param where
	 * @return
	 */
    public List<Article> queryBySql(String where,Integer pNu, Integer count) {

        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("select art.title,art.id,art.cat_id from article art ");
            if (where != null) {
                buffer.append(" where " + where);
                buffer.append(" AND status>0 ");
            }
            buffer.append(" order by id");
            if(count!=null && count>0)
            	buffer.append("  limit " + count);
            
            List<Record> list = Db.find(buffer.toString());
            List<Article> vos = new ArrayList<Article>();
            for(Article a : vos){
            }
            for (Record record : list) {
            	Article obj = createPo();
                SetValueFromRecord.copyProtis(obj, record);
                vos.add(obj);
            }
            return vos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }   

    public PageUtil<Article> getList(Map<String, String> t_where, String columns, Integer pNu, Integer pSize) {
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
                    _s_where.append(" " + entry.getKey() + entry.getValue());
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
            pCount = Integer.valueOf(String.valueOf(total / this.pSize + (total % this.pSize > 0 ? 1 : 0)));
            this.pNu = pNu == null ? 1 : (pCount < pNu ? pCount : pNu);
            page = new PageUtil<Article>();
            if(_where==null || _where.equals("")){
                _where = " status>0 ";
            }else{
                _where = _where + " and status>0 ";
            }
            if(this.pNu>0)
                page.setList(queryBySql(_where, columns," order by add_time desc ", (this.pNu - 1) * pSize, pSize));
            else
                page.setList(queryBySql(_where, columns," order by add_time desc ", 0, pSize));
            page.setCount(total);
            page.setPagecount(pCount);
            page.setPage(this.pNu);
            page.setStatus(1);
        }catch(Exception e){
            e.printStackTrace();
            page.setStatus(0);
        }

        return page;
    }
}
