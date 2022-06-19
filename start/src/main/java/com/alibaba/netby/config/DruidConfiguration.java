/*
package com.alibaba.netby.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author byg
 * @date 2022/5/23 8:01
 **//*

@Configuration
//@RefreshScope
@Data
public class DruidConfiguration {

    @NacosValue("${spring.datasource.druid.url}")
    private String url;

    @NacosValue("${spring.datasource.druid.username}")
    private String username;

    @NacosValue("${spring.datasource.druid.password}")
    private String password;

    @NacosValue("${spring.datasource.druid.driver-class-name}")
    private String driverClassName;

    @Bean(name="datasource")
//    @RefreshScope
    public DruidDataSource dataSource()
    {
        DruidDataSource datasource = new DruidDataSource();
        System.out.println(url);
        datasource.setUrl(this.url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }
}
*/
