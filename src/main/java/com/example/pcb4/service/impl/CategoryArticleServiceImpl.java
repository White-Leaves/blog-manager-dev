package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.CategoryArticle;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.service.CategoryArticleService;
import com.example.pcb4.mapper.CategoryArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author renhq
* @description 针对表【category_article】的数据库操作Service实现
* @createDate 2025-09-16 14:45:47
*/
@Service
public class CategoryArticleServiceImpl extends ServiceImpl<CategoryArticleMapper, CategoryArticle>
    implements CategoryArticleService{

    @Override
    public List<ArticleVo> selectArticleByCategoryId(String categoryId) {
        return List.of();
    }
}




