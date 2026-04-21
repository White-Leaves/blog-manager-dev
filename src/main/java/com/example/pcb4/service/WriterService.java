package com.example.pcb4.service;

import com.example.pcb4.entity.Article;
import com.example.pcb4.entity.Request.WriterRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.WriterVo;
import com.example.pcb4.entity.Writer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author renhq
* @description 针对表【writer】的数据库操作Service
* @createDate 2025-09-16 14:46:08
*/
public interface WriterService extends IService<Writer> {
    void UpdateWriter(WriterRequest request);
    void DeleteWriter(WriterRequest request);
    List<WriterVo> getWriterList();
    List<ArticleVo> getWriterArticleByName(WriterRequest request);
    WriterVo getWriterDetailByName(String name);
    Integer getWriterNum();
    List<WriterVo> getTodayWriterList();
}
