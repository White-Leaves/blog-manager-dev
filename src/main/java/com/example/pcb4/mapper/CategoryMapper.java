package com.example.pcb4.mapper;

import com.example.pcb4.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.CategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author renhq
* @description 针对表【category】的数据库操作Mapper
* @createDate 2025-09-16 14:45:47
* @Entity com.example.pcb4.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    void updateCategory(String Name,Long Id);
    void deleteCategory(Long id);
    List<CategoryVo> getCategoryList();
    CategoryVo getCategoryDetailByName(String name);
    List<ArticleVo> getCategoryArticleByName(String name);
    Integer getCategoryNum();
    List<CategoryVo> getTodayCategoryList();
}




