package top.ybq87.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.ybq87.springcloud.common.CommonResult;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentFeignService {
    
    @GetMapping("/payment/hystrix/payment_ok/{id}")
    CommonResult payment_ok(@PathVariable("id") String id);
    
    @GetMapping("/payment/hystrix/payment_timeout/{id}")
    CommonResult payment_timeout(@PathVariable("id") String id);
    
}