package com.alibaba.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byg
 * @date 2022/6/5 17:06
 **/
@Data
public class UserPO implements Serializable {

    private Integer id;
    private String username;
    private String password;
}
