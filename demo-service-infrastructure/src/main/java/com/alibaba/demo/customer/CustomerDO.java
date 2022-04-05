package com.alibaba.demo.customer;

import lombok.Data;

@Data
public class CustomerDO{
  private String id;
  private String customerId;
  private String memberId;
  private String globalId;
  private long registeredCapital;
  private String companyName;
}
