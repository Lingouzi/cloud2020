package top.ybq87.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * 如果使用了 spring-cloud-starter-netflix-eureka-client 包
 * 可以不需要写 @EnableEurekaClient 注解，都会自动注册到 eureka 了，所以写不写都没问题
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@SpringBootApplication
// @EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
