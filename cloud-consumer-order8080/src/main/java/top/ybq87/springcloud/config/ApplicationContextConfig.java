package top.ybq87.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/25
 */
@Configuration
public class ApplicationContextConfig {
    
    /**
     * LoadBalanced 注解，默认负载均衡
     */
    @Bean
    @LoadBalanced // 手写 ribbon 时要注释掉这个，不然还是用的默认的 ribbon。
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
