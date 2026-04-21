package com.example.pcb4.controller;

import com.example.pcb4.entity.Article;
import com.example.pcb4.entity.Request.WriterRequest;
import com.example.pcb4.entity.Vo.ArticleVo;
import com.example.pcb4.entity.Vo.WriterVo;
import com.example.pcb4.entity.Writer;
import com.example.pcb4.mapper.WriterMapper;
import com.example.pcb4.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/writer")
public class WriterController {
    @Autowired
    private WriterService writerService;

    @PostMapping("/update")
    public ResponseEntity<Map<String,Object>> updateWriter(@RequestBody WriterRequest request){
        try{
            writerService.UpdateWriter(request);
            return ResponseEntity.ok(Map.of("message","修改成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("message",e.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Map<String,Object>> deleteWriter(@RequestBody WriterRequest request){
        try{
            writerService.DeleteWriter(request);
            return ResponseEntity.ok(Map.of("message","修改成功"));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("message",e.getMessage()));
        }
    }

    @GetMapping("/writerList")
    public ResponseEntity<Map<String,Object>> writerList(){
        try{
            List<WriterVo> result = writerService.getWriterList();
            System.out.println(result);
            return ResponseEntity.ok(Map.of("result",result));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/writerDetail")
    public ResponseEntity<Map<String,Object>> writerDetail(@RequestParam String name){
        try{
            System.out.println(name);
            WriterVo result = writerService.getWriterDetailByName(name);
            System.out.println(result);
            return ResponseEntity.ok(Map.of("result",result));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @PostMapping("/writerArticle")
    public ResponseEntity<Map<String,Object>> writerArticle(@RequestBody  WriterRequest request){
        try{
            List<ArticleVo> result = writerService.getWriterArticleByName(request);
            System.out.println(result);
            return ResponseEntity.ok(Map.of("result",result));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/getWriterNum")
    public ResponseEntity<Map<String,Object>> getWriterNum(){
        try{
            return ResponseEntity.ok(Map.of("result",writerService.getWriterNum()));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

    @GetMapping("/getTodayWriter")
    public ResponseEntity<Map<String,Object>> getTodayWriter(){
        try{
            return ResponseEntity.ok(Map.of("result",writerService.getTodayWriterList()));
        }catch (Exception e){
            return ResponseEntity.status(401).body(Map.of("result",e.getMessage()));
        }
    }

}
