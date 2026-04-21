package com.example.pcb4.service;

import com.example.pcb4.entity.Article;
import com.example.pcb4.entity.CategoryArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pcb4.entity.Vo.ArticleVo;

import java.util.List;

/**
* @author renhq
* @description 针对表【category_article】的数据库操作Service
* @createDate 2025-09-16 14:45:47
*/
public interface CategoryArticleService extends IService<CategoryArticle> {
    List<ArticleVo> selectArticleByCategoryId(String categoryId);
}
