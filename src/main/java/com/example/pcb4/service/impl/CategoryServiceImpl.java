package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.Category;
import com.example.pcb4.entity.Request.CategoryRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.CategoryVo;
import com.example.pcb4.service.CategoryService;
import com.example.pcb4.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author renhq
* @description 针对表【category】的数据库操作Service实现
* @createDate 2025-09-16 14:45:47
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Override
    public void UpdateCategory(CategoryRequest request) {

    }

    @Override
    public void DeleteCategory(CategoryRequest request) {

    }

    @Override
    public List<CategoryVo> getCategoryList() {
        return List.of();
    }

    @Override
    public List<ArticleVo> getCategoryArticleByName(CategoryRequest request) {
        return List.of();
    }

    @Override
    public CategoryVo getCategoryDetailByName(String name) {
        return null;
    }

    @Override
    public Integer getCategoryNum() {
        return 0;
    }

    @Override
    public List<CategoryVo> getTodayCategoryList() {
        return List.of();
    }
}




