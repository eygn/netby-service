package com.alibaba.netby.domain.customer;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

//Domain Entity can choose to extends the domain model which is used for DTO
@Data
@Entity
public class User {

    private Integer id;
    private String username;
    private String password;

    public User() {
    }

}
