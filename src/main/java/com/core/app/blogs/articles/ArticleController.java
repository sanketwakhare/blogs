package com.core.app.blogs.articles;

import com.core.app.blogs.articles.dtos.CreateArticleRequestDTO;
import com.core.app.blogs.common.dtos.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(@Autowired ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Message> createArticle(@RequestBody CreateArticleRequestDTO requestDTO) {
        String title = requestDTO.getTitle();
        String body = requestDTO.getBody();
        String authorId = requestDTO.getAuthorId();
        articleService.createArticle(title, body, authorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Message("Article created"));
    }
}
