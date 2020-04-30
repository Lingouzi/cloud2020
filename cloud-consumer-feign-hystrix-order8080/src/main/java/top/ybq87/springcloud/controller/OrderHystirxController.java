package top.ybq87.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;
import top.ybq87.springcloud.service.PaymentFeignService;

/**
 * 注解 @DefaultProperties，默认回退方法不能有参数，返回值要与 Hystrix 方法的返回值相同。
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@DefaultProperties(defaultFallback = "defaultFallBack")
@RestController
public class OrderHystirxController {
    
    @Resource
    private PaymentFeignService paymentFeignService;
    
    @GetMapping("/consumer/payment/hystrix/payment_ok/{id}")
    CommonResult payment_ok(@PathVariable("id") String id) {
        return paymentFeignService.payment_ok(id);
    }
    
    // @HystrixCommand(fallbackMethod = "payment_timeoutHandler", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    // })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/payment_timeout/{id}")
    CommonResult payment_timeout(@PathVariable("id") String id) {
        return paymentFeignService.payment_timeout(id);
    }
    
    /**
     * 超时或者异常的 fallback 方法
     * @param id
     * @return
     */
    public CommonResult payment_timeoutHandler(String id) {
        return CommonResult.failed(Thread.currentThread().getName() + ">>> 消费者端 系统繁忙 >>>>" + " timeout :)");
    }
    
    public CommonResult defaultFallBack() {
        return CommonResult.failed("默认的 fallback");
    }
}
