package com.core.app.blogs.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("articleRepository")
public interface IArticleRepository extends JpaRepository<ArticleModel, String> {

    @Query("SELECT a FROM articles a WHERE a.slug = ?1")
    Optional<ArticleModel> findBySlug(String slug);
}
