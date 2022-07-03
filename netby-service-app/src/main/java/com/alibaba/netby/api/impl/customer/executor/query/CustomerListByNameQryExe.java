package com.alibaba.netby.api.impl.customer.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.netby.dto.customer.CustomerListByNameQry;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.netby.dto.data.customer.CustomerDTO;
import org.springframework.stereotype.Component;


@Component
public class CustomerListByNameQryExe{
    public MultiResponse<CustomerDTO> execute(CustomerListByNameQry cmd) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Frank");
        customerDTOList.add(customerDTO);
        return MultiResponse.of(customerDTOList);
    }
}
