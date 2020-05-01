package top.ybq87.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/25
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8082 {
    
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8082.class);
    }
    
}
