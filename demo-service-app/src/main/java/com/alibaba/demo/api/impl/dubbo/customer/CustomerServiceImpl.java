package com.alibaba.demo.api.impl.dubbo.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.demo.api.impl.dubbo.customer.executor.CustomerAddCmdExe;
import com.alibaba.demo.api.impl.dubbo.customer.executor.query.CustomerListByNameQryExe;
import com.alibaba.demo.dto.customer.CustomerAddCmd;
import com.alibaba.demo.dto.customer.CustomerListByNameQry;
import com.alibaba.demo.api.customer.CustomerServiceI;
import com.alibaba.demo.dto.data.customer.CustomerDTO;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0")
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}