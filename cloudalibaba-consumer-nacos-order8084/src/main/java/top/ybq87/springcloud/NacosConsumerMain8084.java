package top.ybq87.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients 启用 feign
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/3
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumerMain8084 {
    
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain8084.class, args);
    }
}
