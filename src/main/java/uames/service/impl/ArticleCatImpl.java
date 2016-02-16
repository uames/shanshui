package uames.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import uames.po.ArticleCat;
import uames.service.IArticleCat;
import uames.util.SetValueFromRecord;

public class ArticleCatImpl  extends BaseImpl<ArticleCat> implements IArticleCat {
    public void ArticleImpl() {
        tableName = "article_category";
    }
    
    @Override
    public ArticleCat createPo() {
        return new ArticleCat();
    }
    
    /**
     * 分类列表
     * @param where
     * @return
     */
    public List<ArticleCat> queryBySql(String where) {
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("select * from article_category");
            if (where != null) {
                buffer.append(" where " + where);
            }
            List<Record> list = Db.find(buffer.toString());
            List<ArticleCat> vos = new ArrayList<ArticleCat>();
            for (Record record : list) {
            	ArticleCat obj = createPo();
                SetValueFromRecord.copyProtis(obj, record);
                vos.add(obj);
            }
            return vos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public ArticleCat getOne(String where) {
		 StringBuffer buffer = new StringBuffer();
		String sql ="";
		buffer.append("select * from  article_category");
		if(where!=null){
		      buffer.append(" where " + where);
		}
		sql = buffer.toString();
        Record record = Db.findFirst(sql);
        ArticleCat data = new ArticleCat();

        SetValueFromRecord.copyProtis(data, record);
        return data;
    }    
}