package top.ybq87.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;
import top.ybq87.springcloud.common.CommonResult;

/**
 * 简化一下，不写接口了
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@Service
public class PaymentService {
    
    AtomicInteger atomicInteger = new AtomicInteger(0);
    
    public String payment_ok(String id) {
        // int x = atomicInteger.incrementAndGet();
        // if (x % 2 == 0) {
        //     // 模拟超时
        //     // 休眠几秒钟
        //     try {
        //         TimeUnit.SECONDS.sleep(3);
        //         System.out.println("......payment_ok.." + x);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // } else {
        //     // 模拟异常
        //     x = 10 / 0;
        // }
        return Thread.currentThread().getName() + " id:" + id + " ok..";
    }
    
    /**
     * 测试超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "payment_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String payment_timeout(String id) {
        int x = atomicInteger.incrementAndGet();
        if (x % 2 == 0) {
            // 模拟超时
            // 休眠几秒钟
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("......timeout.." + x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 模拟异常
            x = 10 / 0;
        }
        return Thread.currentThread().getName() + " id:" + id + " timeout..";
    }
    
    /**
     * 超时或者异常的 fallback 方法
     * @param id
     * @return
     */
    public String payment_timeoutHandler(String id) {
        return Thread.currentThread().getName() + ">>> 服务提供者 系统繁忙 >>>>" + " timeout :)";
    }
    
    //============== 服务熔断
    
    @HystrixCommand(fallbackMethod = "payment_ciccuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否启用熔断，默认为 true
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 10 次请求，建议:QPS * 窗口秒数 * 60%
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 10s 内，默认 5000
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 50%失败了，那么就熔断，默认 50%
    })
    public CommonResult payment_ciccuitBreaker(Integer id) {
        
        if (id < 0) {
            throw new RuntimeException();
        }
        return CommonResult.success(IdUtil.simpleUUID());
    }
    
    CommonResult payment_ciccuitBreakerHandler(Integer id) {
        return CommonResult.failed("熔断.. Id:" + id);
    }
    
}
