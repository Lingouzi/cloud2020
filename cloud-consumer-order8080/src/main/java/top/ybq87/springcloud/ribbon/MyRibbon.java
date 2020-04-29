package top.ybq87.springcloud.ribbon;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * 面向接口编程
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
public interface MyRibbon {
    
    /**
     * 从服务列表得到想要调用的那个服务
     * @param serviceInstanceList 服务列表
     * @return
     */
    ServiceInstance increment(List<ServiceInstance> serviceInstanceList);
    
    
}
