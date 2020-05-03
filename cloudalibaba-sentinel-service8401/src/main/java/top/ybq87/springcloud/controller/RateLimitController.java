package top.ybq87.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ybq87.springcloud.common.CommonResult;
import top.ybq87.springcloud.myhandler.ConsumerHandlerException;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/3
 */
@RestController
public class RateLimitController {
    
    @GetMapping("/byresource")
    @SentinelResource(value = "byresource", blockHandler = "handleException")
    public CommonResult byresource() {
        return CommonResult.success("success");
    }
    
    public CommonResult handleException(BlockException exception) {
        return CommonResult.failed("fail");
    }
    
    /**
     * 测试公共限流处理方法
     * @return
     */
    @GetMapping("/testCommonHandler")
    @SentinelResource(value = "testCommonHandler", blockHandlerClass = ConsumerHandlerException.class, blockHandler = "handler")
    public CommonResult testCommonHandler() {
        return CommonResult.success();
    }
    
}
