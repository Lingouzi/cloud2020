package top.ybq87.springcloud.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.service.IMessageProviderService;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/2
 */
@RestController
public class StreamMessageController {
    
    @Resource
    private IMessageProviderService messageProviderService;
    
    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProviderService.send();
    }
    
}
