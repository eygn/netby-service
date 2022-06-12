package com.alibaba.demo.api.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.demo.dto.customer.CustomerAddCmd;
import com.alibaba.demo.dto.customer.CustomerListByNameQry;
import com.alibaba.demo.dto.data.customer.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
