package top.ybq87.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/2
 */
@RestController
public class NacosController {
    
    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping("serverPort")
    public String serverPort() {
        return "port :" + serverPort;
    }
    
    @GetMapping("/payment/get/{id}")
    public CommonResult paymentInfo(@PathVariable("id") Integer id) {
        System.out.println(" >>>> " + serverPort + "  >>> id" + id);
        return CommonResult.success(serverPort + " >>> " + id);
    }
}
