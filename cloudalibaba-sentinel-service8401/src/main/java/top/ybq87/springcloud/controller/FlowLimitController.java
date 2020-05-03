package top.ybq87.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/2
 */
@RestController
public class FlowLimitController {
    
    @GetMapping("/test1")
    public String test1() {
        return ">>>>> 1";
    }
    
    @GetMapping("/test2")
    public String test2() {
        return ">>>>> 2";
    }
    
}
