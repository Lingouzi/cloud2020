package top.ybq87.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/27
 */
@RestController
public class PaymentController {
    
    @Value("${server.port}")
    private String serverPort;
    
    @RequestMapping("/payment/zk")
    public String paymentzk() {
        return "zookeeper: " + serverPort + ";" + System.currentTimeMillis();
    }
}
