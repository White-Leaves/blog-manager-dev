package com.example.pcb4.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@TableName("img_records")
@Data
@Builder
public class ImgRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String weight;
    private String inputImg;
    private String outImg;
    private String confidence;
    private String allTime;
    private String conf;
    private String label;
    private String username;
    private String startTime;
}
