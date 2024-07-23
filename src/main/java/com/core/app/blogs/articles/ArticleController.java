package com.core.app.blogs.articles;

import com.core.app.blogs.articles.dtos.ArticleResponseDTO;
import com.core.app.blogs.articles.dtos.CreateArticleRequestDTO;
import com.core.app.blogs.common.dtos.Message;
import com.core.app.blogs.common.utils.MapperUtils;
import com.core.app.blogs.users.UserUtils;
import com.core.app.blogs.users.dtos.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    public ArticleController(@Autowired ArticleService articleService, @Autowired ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Message> createArticle(@RequestBody CreateArticleRequestDTO requestDTO) {
        String title = requestDTO.getTitle();
        String body = requestDTO.getBody();
        String authorId = requestDTO.getAuthorId();
        articleService.createArticle(title, body, authorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Message("Article created"));
    }

    @GetMapping("/{slugId}")
    public ResponseEntity<ArticleResponseDTO> getArticleBySlug(@PathVariable("slugId") String slug) {
        ArticleModel article = articleService.getArticleBySlug(slug);
//        ArticleResponseDTO articleResponseDTO = modelMapper.map(article, ArticleResponseDTO.class);
//        UserResponseDTO authorDetails = modelMapper.map(article.getUser(), UserResponseDTO.class);
//        UserUtils.mapRoles(article.getUser(), authorDetails);
//        articleResponseDTO.setAuthorDetails(authorDetails);
        ArticleResponseDTO articleResponseDTO = MapperUtils.mapArticle(article);
        return ResponseEntity.status(HttpStatus.OK).body(articleResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponseDTO>> getAllArticles() {
        List<ArticleModel> articles = articleService.getAllArticles();

        List<ArticleResponseDTO> articlesDTO = new ArrayList<>();
        for (ArticleModel articleModel : articles) {
            articlesDTO.add(MapperUtils.mapArticle(articleModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(articlesDTO);
    }
}
