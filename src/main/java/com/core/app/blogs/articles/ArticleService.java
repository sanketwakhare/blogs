package com.core.app.blogs.articles;

import com.core.app.blogs.common.exceptions.InvalidModelException;
import com.core.app.blogs.common.exceptions.ModelNotFoundException;
import com.core.app.blogs.common.utils.SlugService;
import com.core.app.blogs.users.IUserRepository;
import com.core.app.blogs.users.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final IUserRepository userRepository;
    private final IArticleRepository articleRepository;

    public ArticleService(@Autowired IUserRepository userRepository, @Autowired IArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    public void createArticle(String title, String body, String authorId) {
        // get author
        Optional<UserModel> user = userRepository.findById(authorId);
        if (user.isEmpty()) {
            throw new InvalidModelException("Article");
        }
        UserModel author = user.get();

        // generate slug
        String slug = SlugService.generateSlug(title);
        ArticleModel articleModel = new ArticleModel();
        articleModel.setTitle(title);
        articleModel.setBody(body);
        articleModel.setSlug(slug);
        articleModel.setUser(author);
        articleModel.setStatus(ArticleStatus.DRAFT);

        articleRepository.save(articleModel);
    }

    // TODO: get only published articles
    // TODO: draft articles should be accessible to only authors which owns the article
    public ArticleModel getArticleBySlug(String slug) {
        Optional<ArticleModel> dbArticle = articleRepository.findBySlug(slug);
        if (dbArticle.isEmpty()) {
            throw new ModelNotFoundException("Article");
        }
        return dbArticle.get();
    }

    public List<ArticleModel> getAllArticles() {
        return articleRepository.findAll();
    }

    public void updateArticleStatus(String articleId, ArticleStatus status) {
        Optional<ArticleModel> dbArticle = articleRepository.findById(articleId);
        if(dbArticle.isEmpty()) {
            throw new ModelNotFoundException("Article");
        }
        ArticleModel articleModel = dbArticle.get();
        articleModel.setStatus(status);
        articleRepository.save(articleModel);
    }
}
