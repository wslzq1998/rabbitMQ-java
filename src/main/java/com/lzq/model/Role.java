package com.lzq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    //主键id
    private Integer id;
    //角色名称
    private String name;
}
