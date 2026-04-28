package com.example.pcb4.entity.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private String id;
    private String writerName;
    private String title;
    private String content;
    private String keyword;
}
