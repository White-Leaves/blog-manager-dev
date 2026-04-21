package com.example.pcb4.mapper;

import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.WriterVo;
import com.example.pcb4.entity.Writer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author renhq
* @description 针对表【writer】的数据库操作Mapper
* @createDate 2025-09-16 14:46:08
* @Entity com.example.pcb4.entity.Writer
*/
@Mapper
public interface WriterMapper extends BaseMapper<Writer> {
    void updateWriter(String Name,Long Id);
    void deleteWriter(Long id);
    List<WriterVo> getWriterList();
    WriterVo getWriterDetailByName(String name);
    List<ArticleVo> getWriterArticleByName(String name);
    Integer getWriterNum();
    List<WriterVo> getTodayWriterList();
}




