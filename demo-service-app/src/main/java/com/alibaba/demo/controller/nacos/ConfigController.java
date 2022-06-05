package com.alibaba.demo.controller.nacos;

/**
 * @author byg
 * @date 2022/5/29 11:15
 **/

import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @Value("${dubbo.registry.address}")
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public SingleResponse<String> get() {
        return SingleResponse.of(address);
    }
}
