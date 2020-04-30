package top.ybq87.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;
import top.ybq87.springcloud.service.PaymentService;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@RestController
public class PaymentHystrixController {
    
    
    @Autowired
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String servicePort;
    
    @GetMapping("/payment/hystrix/payment_ok/{id}")
    public CommonResult payment_ok(@PathVariable("id") String id) {
        String payment_ok = paymentService.payment_ok(id);
        return CommonResult.success(payment_ok + " " + servicePort);
    }
    
    @GetMapping("/payment/hystrix/payment_timeout/{id}")
    public CommonResult payment_timeout(@PathVariable("id") String id) {
        String payment_timeout = paymentService.payment_timeout(id);
        return CommonResult.success(payment_timeout + " " + servicePort);
    }
    
    //======== 熔断
    
    @GetMapping("/payment/hystrix/payment_ciccuitBreaker/{id}")
    public CommonResult payment_ciccuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.payment_ciccuitBreaker(id);
    }
}
