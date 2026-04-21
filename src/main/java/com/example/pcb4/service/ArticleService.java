package com.example.pcb4.service;

import com.example.pcb4.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pcb4.entity.Request.ArticleRequest;
import com.example.pcb4.entity.Vo.ArticleVo;

import java.util.List;

/**
* @author renhq
* @description 针对表【article】的数据库操作Service
* @createDate 2025-09-16 14:45:08
*/
public interface ArticleService extends IService<Article> {
    void updateArticle(ArticleRequest articleRequest);
    void deleteArticle(ArticleRequest articleRequest);
    void createArticle(ArticleRequest articleRequest);
    Article getArticleById(String id);
    List<ArticleVo> getArticleList();
    Integer getArticleNum();
    List<ArticleVo> getTodayArticleList();
}
