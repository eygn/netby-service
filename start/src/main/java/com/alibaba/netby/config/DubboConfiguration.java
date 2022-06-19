/*
package com.alibaba.netby.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author byg
 * @date 2022/5/23 8:13
 **//*

@Configuration
public class DubboConfiguration {


    @NacosValue("${dubbo.registry.address}")
    private String registryAddress;

    @NacosValue("${dubbo.protocol.name}")
    private String protocolName;

    @NacosValue("${dubbo.protocol.serialization}")
    private String protocolSerialization;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("netby-service");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        System.err.println(registryAddress);
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress(registryAddress);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(20880);
        protocolConfig.setSerialization(protocolSerialization);
        return protocolConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(2000);
        consumerConfig.setCheck(true);
        return consumerConfig;
    }


}
*/
