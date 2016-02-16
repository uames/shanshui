package uames.vo;

import java.util.ArrayList;
import java.util.List;

import uames.po.Article;
import uames.service.IArticle;
import uames.service.impl.ArticleImpl;

public class ArticleVo extends BaseVo<Article> {
	private ArticleVo article;

	public ArticleVo(Article t) {
		super(t);
	}

	public static List<ArticleVo> createList(List<Article> ls) {
		List<ArticleVo> result = new ArrayList<ArticleVo>();
		if (ls != null) {
			for (Article g : ls) {
				result.add(new ArticleVo(g));
			}
		}
		return result;
	}
	public static  ArticleVo getArtVo(Article g)
	{
		return new ArticleVo(g);
	}

	public ArticleVo getArticle() {
		if (article == null) {
			IArticle artSvc = new ArticleImpl();
			article = new ArticleVo(artSvc.getOne(getPo().getId()));
		}
		return article;
	}
	public ArticleVo getArtById(Long id) {
		if (article == null) {
			IArticle artSvc = new ArticleImpl();
			article = new ArticleVo(artSvc.getOne(id));
		}
		return article;
	}
}
