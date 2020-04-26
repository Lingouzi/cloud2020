package top.ybq87.springcloud.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    public CommonResult<String> create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询：" + payment + ";serverPort" + serverPort);
        if (payment != null) {
            return CommonResult.success("查询：" + payment.toString() + ";serverPort" + serverPort);
        }
        return CommonResult.failed("查询失败：" + id);
    }
}
