package top.ybq87.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.ybq87.springcloud.common.CommonResult;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/3
 */
public class ConsumerHandlerException {
    
    
    public static CommonResult handler(BlockException exception) {
        return CommonResult.failed("handler");
    }
    
    public static CommonResult handler2(BlockException exception) {
        return CommonResult.failed("handler2");
    }
}
