package com.alibaba.demo.api.impl.dubbo.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.demo.api.impl.dubbo.customer.executor.CustomerAddCmdExe;
import com.alibaba.demo.api.impl.dubbo.customer.executor.query.CustomerListByNameQryExe;
import com.alibaba.demo.dto.CustomerAddCmd;
import com.alibaba.demo.dto.CustomerListByNameQry;
import com.alibaba.demo.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;
import com.alibaba.demo.api.customer.CustomerServiceI;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}