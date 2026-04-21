package com.example.pcb4.controller;

import com.example.pcb4.entity.Request.CategoryRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.CategoryVo;
import com.example.pcb4.service.CategoryArticleService;
import com.example.pcb4.service.CategoryService;
import com.example.pcb4.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryService CategoryService;
    @Autowired
    private CategoryArticleService CategoryArticleService;

    @PostMapping("/update")
    public ResponseEntity<Map<String,Object>> updateCategory(@RequestBody CategoryRequest request){
        try{
            CategoryService.UpdateCategory(request);
            return ResponseEntity.ok(Map.of("message","修改成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("message",e.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Map<String,Object>> deleteCategory(@RequestBody CategoryRequest request){
        try{
            CategoryService.DeleteCategory(request);
            return ResponseEntity.ok(Map.of("message","修改成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("message",e.getMessage()));
        }
    }

    @GetMapping("/CategoryList")
    public ResponseEntity<Map<String,Object>> CategoryList(){
        try{
            List<CategoryVo> result = CategoryService.getCategoryList();
            System.out.println(result);
            return ResponseEntity.ok(Map.of("result",result));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/CategoryDetail")
    public ResponseEntity<Map<String,Object>> CategoryDetail(@RequestParam String name){
        try{
            System.out.println(name);
            CategoryVo result = CategoryService.getCategoryDetailByName(name);
            System.out.println(result);
            return ResponseEntity.ok(Map.of("result",result));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @PostMapping("/CategoryArticle")
    public ResponseEntity<Map<String,Object>> CategoryArticle(@RequestBody  CategoryRequest request){
        try{
            String id = request.getId();
            List<ArticleVo> result = CategoryArticleService.selectArticleByCategoryId(id);
            System.out.println(result);
            return ResponseEntity.ok(Map.of("result",result));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/getCategoryNum")
    public ResponseEntity<Map<String,Object>> getCategoryNum(){
        try{
            return ResponseEntity.ok(Map.of("result",CategoryService.getCategoryNum()));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/getTodayCategory")
    public ResponseEntity<Map<String,Object>> getTodayCategory(){
        try{
            return ResponseEntity.ok(Map.of("result",CategoryService.getTodayCategoryList()));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

}