package top.ybq87.springcloud.controller;

import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.ybq87.springcloud.common.CommonResult;
import top.ybq87.springcloud.entities.Payment;
import top.ybq87.springcloud.ribbon.MyRibbonUtils;

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
public class OrderContrller {
    
    // 单机环境下可以写死没问题，
    // public static final String PAYMENT_URL = "http://localhost:8081";
    // 集群环境要写对应的服务的 name
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    
    
    @Resource
    private RestTemplate restTemplate;
    
    @Autowired
    private MyRibbonUtils myRibbonUtils;
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @PostMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
    
    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult getForEntities(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate
                .getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return CommonResult.success(entity.getBody());
    }
    
    @PostMapping("/consumer/payment/postForEntities")
    public CommonResult postForEntities(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate
                .postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return CommonResult.success(entity.getBody());
    }
    
    @GetMapping("/consumer/payment/get3/{id}")
    public CommonResult getForEntities3(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance increment = myRibbonUtils.increment(instances);
        System.out.println(increment.getUri());
        ResponseEntity<CommonResult> entity = restTemplate
                .getForEntity(increment.getUri() + "/payment/get/" + id, CommonResult.class);
        return CommonResult.success(entity.getBody());
    }
    
    
    @GetMapping("/payment/sleuth")
    public CommonResult paymentSleuth() {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/sleuth", CommonResult.class);
        return CommonResult.success(entity.getBody());
    }
}
