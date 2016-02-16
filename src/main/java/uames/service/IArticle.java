package uames.service;

import uames.po.Article;

public interface IArticle extends IBase<Article> {
	 public Article getArticleById(Long id);
}
