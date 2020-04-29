package top.ybq87.springcloud.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;
import top.ybq87.springcloud.entities.Payment;
import top.ybq87.springcloud.service.IPaymentService;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/25
 */
@Slf4j
@RestController
public class PaymentController {
    
    @Resource
    private IPaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    /**
     ** 如果使用的是 netfix 的 import com.netflix.discovery.DiscoveryClient
     * 使用 @Autowired 注解这里不能注入，使用 @Resource 才行
     ** 这里使用 springcloud 的 DiscoveryClient 可以使用 Autowired 注解
     */
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @PostMapping("/payment/create")
    public CommonResult<String> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入：" + result + ";serverPort" + serverPort);
        if (result > 0) {
            return CommonResult.success("插入：" + result + ";serverPort" + serverPort);
        }
        return CommonResult.failed();
    }
    
    @GetMapping("/payment/get/{id}")
    public CommonResult<String> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询：" + payment + ";serverPort" + serverPort);
        if (payment != null) {
            return CommonResult.success("查询：" + payment.toString() + ";serverPort" + serverPort);
        }
        return CommonResult.failed("查询失败：" + id);
    }
    
    @GetMapping("/payment/discoveryClient")
    public CommonResult discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service:" + service);
        }
        
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println("instance>>> " + instance.toString());
        }
        
        return CommonResult.success(discoveryClient);
    }
    
    /**
     * 测试 feign 的超时时间，feign 默认超时是 1s
     * @return
     */
    @GetMapping("/payment/timeoutFeign")
    public CommonResult timeoutFeign() {
        // 休眠几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CommonResult.success();
    }
    
}
