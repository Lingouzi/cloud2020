package top.ybq87.springcloud.service;

import org.springframework.stereotype.Component;
import top.ybq87.springcloud.common.CommonResult;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/30
 */
@Component
public class PaymenHystrixFeignService implements PaymentFeignService {
    
    @Override
    public CommonResult payment_ok(String id) {
        return CommonResult.failed("payment_ok >>>" + id);
    }
    
    @Override
    public CommonResult payment_timeout(String id) {
        return CommonResult.failed("payment_timeout >>>" + id);
    }
}
