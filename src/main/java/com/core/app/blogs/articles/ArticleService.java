package com.core.app.blogs.articles;

import com.core.app.blogs.common.utils.SlugService;
import com.core.app.blogs.users.IUserRepository;
import com.core.app.blogs.users.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(user.isEmpty()) {
            // throw exception
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
}
