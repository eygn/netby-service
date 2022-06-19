package com.alibaba.netby.customer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDO getById(String customerId);
}
