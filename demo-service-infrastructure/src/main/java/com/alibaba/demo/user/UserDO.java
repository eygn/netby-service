package com.alibaba.demo.user;

/**
 * @Description
 * @Author byg
 * @Date 2022/3/27 19:18
 * @Version 0.1
 **/

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class UserDO implements Serializable, Comparable {

    private static final long serialVersionUID = -1205226416664488559L;
    private Integer id;
    private String username;
    private String password;

    @Override
    public int compareTo(Object o) {
        UserDO u = (UserDO) o;
        return this.id.compareTo(u.id);
    }
}
