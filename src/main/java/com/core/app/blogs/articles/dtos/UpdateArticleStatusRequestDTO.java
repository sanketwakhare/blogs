package com.core.app.blogs.articles.dtos;

import com.core.app.blogs.articles.ArticleStatus;
import lombok.Data;

@Data
public class UpdateArticleStatusRequestDTO {
    private String articleId;
    private ArticleStatus status;
}
