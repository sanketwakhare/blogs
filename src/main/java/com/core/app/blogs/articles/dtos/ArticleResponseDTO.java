package com.core.app.blogs.articles.dtos;

import com.core.app.blogs.articles.ArticleStatus;
import com.core.app.blogs.users.dtos.UserResponseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleResponseDTO {
    private String id;
    private String title;
    private String slug;
    private String body;
    private ArticleStatus status;
    private Date createdAt;
    private Date updatedAt;
    private UserResponseDTO authorDetails;
}
