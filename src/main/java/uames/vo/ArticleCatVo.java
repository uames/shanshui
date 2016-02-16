package uames.vo;

import java.util.ArrayList;
import java.util.List;

import uames.po.ArticleCat;

public class ArticleCatVo extends BaseVo<ArticleCat> {

	public ArticleCatVo(ArticleCat t) {
		super(t);
	}

	public static List<ArticleCatVo> createList(List<ArticleCat> ls) {
		List<ArticleCatVo> result = new ArrayList<ArticleCatVo>();
		if (ls != null) {
			for (ArticleCat g : ls) {
				result.add(new ArticleCatVo(g));
			}
		}
		return result;
	}	
}
