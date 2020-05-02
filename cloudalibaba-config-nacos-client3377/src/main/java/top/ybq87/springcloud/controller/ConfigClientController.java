package top.ybq87.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;

/**
 * 使用 actuator 监控的方式刷新配置获取，如果配置中心修改了配置文件，需要运维手动调用一下
 * curl -X POST http://localhost:3355/actuator/refresh
 * 才能刷新 client 的信息【必须是 post 请求】。
 *
 * @RefreshScope 保证动态刷新
 *
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/1
 */
@Slf4j
@RefreshScope
@RestController
public class ConfigClientController {
    
    /**
     * 因为是config-client，会从配置中心，读取配置文件信息，
     * 我们的 config-dev.yml 中有一条信息：
     * config:
     *   info: xxx
     * 这里我们 client 的配置文件中是没有这个配置的，如果我们访问可以得到这个 info，说明读取成功
     */
    @Value("${config.info}")
    private String info;
    
    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping("/configInfo")
    public CommonResult configInfo() {
        log.info(".. configInfo >>> " + info);
        return CommonResult.success(info + " >>> " + serverPort);
    }
}
