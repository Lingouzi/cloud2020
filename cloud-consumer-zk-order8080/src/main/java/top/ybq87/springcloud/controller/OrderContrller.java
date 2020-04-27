package top.ybq87.springcloud.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/25
 */
@Slf4j
@RestController
public class OrderContrller {
    
    public static final String PAYMENT_URL = "http://cloud-payment-service";
    
    
    @Resource
    private RestTemplate restTemplate;
    
    @GetMapping("/consumer/payment/zk")
    public String zk() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
