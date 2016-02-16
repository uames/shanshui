package uames.process;

import java.util.ArrayList;
import java.util.List;

import uames.po.Article;
import uames.po.ArticleCat;
import uames.service.impl.ArticleCatImpl;
import uames.service.impl.ArticleImpl;
import uames.util.UamesUtil;
import uames.vo.ArticleVo;

public class ArticlePrc {
	/**
	 * 消息 / 通知列表
	 * 
	 * @param type
	 * @param count (读取数量)
	 * @return
	 */
	public List<ArticleVo> getArtList(String type, Integer count) {
		List<ArticleVo> result = new ArrayList<ArticleVo>();
		try {
			List<Article> vos = new ArrayList<Article>();

			ArticleCat po = new ArticleCatImpl().getOne(" cat_name = \"" + type + "\"");
			if (po != null && po.getId() != null && po.getId() > 0) {
				Long catid = po.getId();
				vos = new ArticleImpl().queryBySql(" cat_id= " + catid,0, count);
				if (vos != null)
					result = ArticleVo.createList(vos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获得id
	 * 
	 * @param str
	 * @param t (0：分类id;1：一级id)
	 * @return
	 */
	public Long getCurrId(String str, Integer t) {
		Long id = Long.valueOf(0);
		String[] ids;
		ids = str.split("-");
		if(ids[0].length()>4){
    		 ids[0] = ids[0].substring(5, ids[0].length());
		}
		if (ids.length >= 2) {
			if (!UamesUtil.IsNullOrWhiteSpace(ids[t]) && getDocNum(ids[t]) > 0)
				id = getDocNum(ids[t]);
		}else{
			if (getDocNum(ids[0]) > 0)
			{
				if(!UamesUtil.IsNullOrWhiteSpace(ids[t]) && getDocNum(ids[t]) > 0)
					id = getDocNum(ids[t]);
		
			Article vo = new Article();
			vo = new ArticleImpl().getArticMinsort(id);
			id = vo.getId();
			}
		}
		return id;
	}

	private Long getDocNum(String s) {
		try {
			return Long.valueOf(s);
		} catch (Exception e) {
			return (long) 0;
		}
	}

	/**
	 * 一级分类
	 * 
	 * @param catid
	 * @return（0关于我们；1帮助中心）
	 */
	public Integer getType(Long catid) {
		Integer type = 0;
		ArticleCat po = new ArticleCatImpl().getOne(" id = " + catid);
		if (po != null && po.getId() > 0) {
			if (po.getCat_name().equals("关于我们")) {
				type = 0;
			} else {
				type = 1;
			}
		}
		return type;
	}
}
