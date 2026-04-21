package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.Request.WriterRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.WriterVo;
import com.example.pcb4.entity.Writer;
import com.example.pcb4.service.WriterService;
import com.example.pcb4.mapper.WriterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author renhq
* @description 针对表【writer】的数据库操作Service实现
* @createDate 2025-09-16 14:46:08
*/
@Service
public class WriterServiceImpl extends ServiceImpl<WriterMapper, Writer>
    implements WriterService{

    @Autowired
    private WriterMapper writerMapper;

    @Override
    public void UpdateWriter(WriterRequest request) {
        String id = request.getId();
        String name = request.getWriterName();
        writerMapper.updateWriter(name, Long.getLong(id));
    }

    @Override
    public void DeleteWriter(WriterRequest request) {
        String id = request.getId();
        writerMapper.deleteWriter(Long.getLong(id));
    }

    @Override
    public List<WriterVo> getWriterList() {
        return writerMapper.getWriterList();
    }

    @Override
    public List<ArticleVo> getWriterArticleByName(WriterRequest request) {
        String name = request.getWriterName();
        return writerMapper.getWriterArticleByName(name);
    }

    @Override
    public WriterVo getWriterDetailByName(String name) {
        return writerMapper.getWriterDetailByName(name);
    }

    @Override
    public Integer getWriterNum() {
        return writerMapper.getWriterNum();
    }

    @Override
    public List<WriterVo> getTodayWriterList() {
        return writerMapper.getTodayWriterList();
    }
}




