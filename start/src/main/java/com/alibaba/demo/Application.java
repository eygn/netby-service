package com.alibaba.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author byg
 */
@Slf4j
@MapperScan("com.alibaba.demo")
@EnableDubbo(scanBasePackages = "com.alibaba.demo")
@NacosPropertySource(dataId = "config.yaml", autoRefreshed = true)
@MapperScan("com.alibaba.demo")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("start finish");
    }
}
