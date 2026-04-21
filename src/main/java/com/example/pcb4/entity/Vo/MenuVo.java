package com.example.pcb4.entity.Vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String menuCode;
    private Long parentId;
    private Integer nodeType;
    private String iconUrl;
    private Integer sort;
    private String url;
    private Integer level;
    private String path;


    List<MenuVo> childMenu;

}
