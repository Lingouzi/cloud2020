package top.ybq87.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

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
        System.out.println("payment_ok.." + atomicInteger.incrementAndGet());
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
        return Thread.currentThread().getName() + ">>> 系统繁忙 >>>>" + " timeout :)";
    }
    
}
