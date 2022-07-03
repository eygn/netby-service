package com.alibaba.netby.api.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.netby.dto.customer.CustomerAddCmd;
import com.alibaba.netby.dto.customer.CustomerListByNameQry;
import com.alibaba.netby.dto.data.customer.CustomerDTO;

public interface CustomerServiceFacade {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
