package top.ybq87.springcloud.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;
import top.ybq87.springcloud.service.PaymentFeignService;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@RestController
public class OrderHystirxController {
    
    @Resource
    private PaymentFeignService paymentFeignService;
    
    @GetMapping("/consumer/payment/hystrix/payment_ok/{id}")
    CommonResult payment_ok(@PathVariable("id") String id) {
        return paymentFeignService.payment_ok(id);
    }
    
    @GetMapping("/consumer/payment/hystrix/payment_timeout/{id}")
    CommonResult payment_timeout(@PathVariable("id") String id) {
        return paymentFeignService.payment_timeout(id);
    }
    
}
