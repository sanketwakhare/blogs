package com.core.app.blogs.articles;

import com.core.app.blogs.common.BaseModel;
import com.core.app.blogs.users.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "articles")
@Builder
public class ArticleModel extends BaseModel {

    @NonNull
    @Size(min = 10, max = 150, message = "Title must be between 10 and 150 characters")
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @NonNull
    @Column(name = "slug", nullable = false, length = 100, unique = true)
    private String slug;

    @NonNull
    @Column(name = "body", nullable = false, length = 3000)
    private String body;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ArticleStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserModel user;
}
