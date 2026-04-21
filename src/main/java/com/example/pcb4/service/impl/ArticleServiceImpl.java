package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.Article;
import com.example.pcb4.entity.Request.ArticleRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.WriterVo;
import com.example.pcb4.entity.Writer;
import com.example.pcb4.mapper.WriterMapper;
import com.example.pcb4.service.ArticleService;
import com.example.pcb4.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author renhq
* @description 针对表【article】的数据库操作Service实现
* @createDate 2025-09-16 14:45:08
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private WriterMapper writerMapper;

    @Override
    public void updateArticle(ArticleRequest articleRequest) {
        String writerName = articleRequest.getWriterName();
        String title = articleRequest.getTitle();
        String context = articleRequest.getContent();
        Long id = Long.parseLong(articleRequest.getId());
        System.out.println(context);
        articleMapper.updateArticleById(id,writerName,title,context);
    }

    @Override
    public void deleteArticle(ArticleRequest articleRequest) {
        Long id = Long.parseLong(articleRequest.getId());
        System.out.println(id);
        articleMapper.deleteArticleById(id);
    }

    @Override
    public void createArticle(ArticleRequest articleRequest) {
        String writerName = articleRequest.getWriterName();
        WriterVo writerVo = writerMapper.getWriterDetailByName(writerName);
        Integer writerId = writerVo.getId();
        String title = articleRequest.getTitle();
        String content = articleRequest.getContent();
        articleMapper.createArticle(writerId,title,content);
    }

    @Override
    public Article getArticleById(String id) {
        return articleMapper.selectById(Integer.getInteger(id));
    }

    @Override
    public List<ArticleVo> getArticleList() {
        List<Article> articlesList = articleMapper.getArticleList();
        return getArticleVos(articlesList);
    }

    @Override
    public Integer getArticleNum() {
        return articleMapper.getArticleNum();
    }

    @Override
    public List<ArticleVo> getTodayArticleList() {
        List<Article> articlesList = articleMapper.getTodayArticleList();
        return getArticleVos(articlesList);
    }

    private List<ArticleVo> getArticleVos(List<Article> articlesList) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : articlesList) {
            Integer writerId = article.getWriterId();
            Writer writer = writerMapper.selectById(writerId);
            String writerName = writer.getWriterName();
            ArticleVo articleVo = new ArticleVo();

            articleVo.setTitle(article.getTitle());
            articleVo.setContent(article.getContent());
            articleVo.setStatus(article.getStatus());
            articleVo.setId(article.getId());
            articleVo.setWriterId(writerId);
            articleVo.setWriterName(writerName);
            articleVoList.add(articleVo);
        }
        return  articleVoList;
    }


}




