package com.core.app.blogs.articles.dtos;

import lombok.Data;

@Data
public class CreateArticleRequestDTO {
    private String title;
    private String body;
    private String authorId;
}
