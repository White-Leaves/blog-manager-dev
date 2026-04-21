package com.example.pcb4.mapper;

import com.example.pcb4.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author renhq
* @description 针对表【article】的数据库操作Mapper
* @createDate 2025-09-16 14:45:08
* @Entity com.example.pcb4.entity.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    void updateArticleById(Long id,String writerName,String title,String context);
    void deleteArticleById(Long id);
    List<Article> getArticleList();
    Article getArticleDetailById(Long id);
    Integer getArticleNum();
    List<Article> getTodayArticleList();
    void createArticle(Integer writerId, String title, String content);
}




