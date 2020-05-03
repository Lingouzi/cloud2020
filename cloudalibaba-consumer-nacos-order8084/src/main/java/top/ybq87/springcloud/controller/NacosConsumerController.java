package top.ybq87.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.ybq87.springcloud.common.CommonResult;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/3
 */
@RestController
public class NacosConsumerController {
    
    AtomicInteger atomicInteger = new AtomicInteger(0);
    
    @Resource
    private RestTemplate restTemplate;
    
    @Value("${service-url.nacos-payment-uri}")
    public String serverURI;
    
    @GetMapping("/consumer/payment/get/{id}")
    @SentinelResource(value = "fallback", fallback = "handler1")
    public CommonResult paymentInfo(@PathVariable("id") Integer id) {
        System.out.println("consumer >>>> " + id + " 》》》》" + serverURI);
        int i = atomicInteger.incrementAndGet();
        if (i % 2 == 0) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(serverURI + "/payment/get/" + id, CommonResult.class);
    }
    
    /**
     * 必须要加 Throwable e 参数？或者说抓取到异常信息？
     * @param id
     * @param e
     * @return
     */
    public CommonResult handler1(Integer id, Throwable e) {
        return CommonResult.failed("handler1:>>>>id:" + id + "," + e.getMessage());
    }
}
