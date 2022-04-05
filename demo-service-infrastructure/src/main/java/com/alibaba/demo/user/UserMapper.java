package com.alibaba.demo.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author byg
 * @Date 2022/3/27 19:23
 * @Version 0.1
 **/

@Mapper
public interface UserMapper {

    Integer addUser(UserDO user);

    List<UserDO> list();

    void deleteAll();

    UserDO getById(String userId);
}
