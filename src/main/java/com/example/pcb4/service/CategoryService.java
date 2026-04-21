package com.example.pcb4.service;

import com.example.pcb4.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pcb4.entity.Request.CategoryRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.CategoryVo;

import java.util.List;

/**
* @author renhq
* @description 针对表【category】的数据库操作Service
* @createDate 2025-09-16 14:45:47
*/
public interface CategoryService extends IService<Category> {
    void UpdateCategory(CategoryRequest request);
    void DeleteCategory(CategoryRequest request);
    List<CategoryVo> getCategoryList();
    List<ArticleVo> getCategoryArticleByName(CategoryRequest request);
    CategoryVo getCategoryDetailByName(String name);
    Integer getCategoryNum();
    List<CategoryVo> getTodayCategoryList();
}
