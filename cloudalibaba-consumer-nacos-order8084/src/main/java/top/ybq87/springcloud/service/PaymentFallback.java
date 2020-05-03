package top.ybq87.springcloud.service;

import org.springframework.stereotype.Component;
import top.ybq87.springcloud.common.CommonResult;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/3
 */
@Component
public class PaymentFallback implements PaymentFeignService {
    
    @Override
    public CommonResult paymentInfo(Integer id) {
        return CommonResult.failed("降级。。");
    }
}
