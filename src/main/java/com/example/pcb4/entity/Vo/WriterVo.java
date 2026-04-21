package com.example.pcb4.entity.Vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain=true)
public class WriterVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String writerName;
}
