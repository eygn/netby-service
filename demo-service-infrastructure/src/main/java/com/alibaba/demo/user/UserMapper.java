package com.alibaba.demo.user;

import com.alibaba.demo.dto.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description
 * @Author byg
 * @Date 2022/3/27 19:23
 * @Version 0.1
 **/

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    List<UserDO> queryByPage(UserPO po, RowBounds rowBounds);

    int countByPage(UserPO po);
}
