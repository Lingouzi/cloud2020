package top.ybq87.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.ybq87.springcloud.common.CommonResult;

/**
 *
 * feign 接口，然后必须写一个兜底的方法
 *
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/3
 */
@Component
@FeignClient(value = "nacos-provider-service", fallback = PaymentFallback.class)
public interface PaymentFeignService {
    
    @GetMapping("/payment/get/{id}")
    CommonResult paymentInfo(@PathVariable("id") Integer id);
    
}
