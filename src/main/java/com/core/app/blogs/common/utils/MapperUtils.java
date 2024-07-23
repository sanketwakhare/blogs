package com.core.app.blogs.common.utils;

import com.core.app.blogs.articles.ArticleModel;
import com.core.app.blogs.articles.dtos.ArticleResponseDTO;
import com.core.app.blogs.users.UserUtils;
import com.core.app.blogs.users.dtos.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperUtils {

    private static ModelMapper modelMapper = null;

    public MapperUtils(@Autowired ModelMapper modelMapper) {
        MapperUtils.modelMapper = modelMapper;
    }

    public static ArticleResponseDTO mapArticle(ArticleModel articleModel) {
        ArticleResponseDTO articleResponseDTO = modelMapper.map(articleModel, ArticleResponseDTO.class);
        UserResponseDTO authorDetails = modelMapper.map(articleModel.getUser(), UserResponseDTO.class);
        UserUtils.mapRoles(articleModel.getUser(), authorDetails);
        articleResponseDTO.setAuthorDetails(authorDetails);
        return articleResponseDTO;
    }
}
