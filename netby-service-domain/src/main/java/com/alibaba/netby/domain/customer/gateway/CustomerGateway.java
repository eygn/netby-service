package com.alibaba.netby.domain.customer.gateway;

import com.alibaba.netby.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
