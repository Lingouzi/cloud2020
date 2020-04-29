package top.ybq87.springcloud.service;

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
    
    public String payment_timeout(String id) {
        // 休眠几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("......timeout.." + atomicInteger.incrementAndGet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " id:" + id + " timeout..";
    }
    
}
