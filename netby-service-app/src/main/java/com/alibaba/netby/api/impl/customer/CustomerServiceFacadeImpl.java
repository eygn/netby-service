package com.alibaba.netby.api.impl.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.netby.api.impl.customer.executor.query.CustomerListByNameQryExe;
import com.alibaba.netby.api.impl.customer.executor.CustomerAddCmdExe;
import com.alibaba.netby.dto.customer.CustomerAddCmd;
import com.alibaba.netby.dto.customer.CustomerListByNameQry;
import com.alibaba.netby.api.customer.CustomerServiceFacade;
import com.alibaba.netby.dto.data.customer.CustomerDTO;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0")
@CatchAndLog
public class CustomerServiceFacadeImpl implements CustomerServiceFacade {

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