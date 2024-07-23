package com.core.app.blogs.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("articleRepository")
public interface IArticleRepository extends JpaRepository<ArticleModel, String> {
}
