package com.example.pcb4.controller;

import com.example.pcb4.entity.Article;
import com.example.pcb4.entity.Request.ArticleRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/update")
    public ResponseEntity<Map<String,Object>> updateArticle(@RequestBody ArticleRequest request){
        try{
            articleService.updateArticle(request);
            return ResponseEntity.ok(Map.of("result","修改成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }

    }

    @GetMapping("/articleList")
    public ResponseEntity<Map<String,Object>> getArticleList(){
        try{
            List<ArticleVo> articleList = articleService.getArticleList();

            return ResponseEntity.ok(Map.of("result",articleList));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }


    }

    @PostMapping("/delete")
    public ResponseEntity<Map<String,Object>> deleteArticle(@RequestBody ArticleRequest request){
        try{
            articleService.deleteArticle(request);
            return ResponseEntity.ok(Map.of("result","删除成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @PostMapping("/articleDetail")
    public ResponseEntity<Map<String,Object>> articleDetail(@RequestBody ArticleRequest request){
        try{
            return ResponseEntity.ok(Map.of("result",articleService.getArticleById(request.getId())));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/getArticleNum")
    public ResponseEntity<Map<String,Object>> getArticleNum(){
        try{
            return ResponseEntity.ok(Map.of("result",articleService.getArticleNum()));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/getTodayArticle")
    public ResponseEntity<Map<String,Object>> getTodayArticle(){
        try{
            return ResponseEntity.ok(Map.of("result",articleService.getTodayArticleList()));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> createArticle(@RequestBody ArticleRequest request){
        try{
            articleService.createArticle(request);
            return ResponseEntity.ok(Map.of("result","添加成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

}
