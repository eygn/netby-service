package com.alibaba.netby.domain.customer.gateway;

import com.alibaba.netby.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
