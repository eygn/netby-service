package com.alibaba.demo.dto.user;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class UserListByNameQry extends Query{
   private String username;
}
