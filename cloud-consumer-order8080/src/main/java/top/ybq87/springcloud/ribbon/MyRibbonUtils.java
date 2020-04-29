package top.ybq87.springcloud.ribbon;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/29
 */
@Component
public class MyRibbonUtils implements MyRibbon {
    
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    
    /**
     * 不允许修改
     * @param serviceInstanceList 服务列表
     * @return
     */
    @Override
    public final ServiceInstance increment(List<ServiceInstance> serviceInstanceList) {
        /*
        思路：
        1、记录一下访问次数，使用 AtomicInteger 保证原子性，因为是多线程访问的
        2、次数 % 已有服务数量 = 取余得到要访问的服务器的角标 index
        3、返回
         */
        int serviceNum = serviceInstanceList.size();
        ServiceInstance serviceInstance;
        int i;
        // cas 自旋
        do {
            i = atomicInteger.get();
            // 防止超出 integer 最大值
            if(i >= Integer.MAX_VALUE){
                i = 0;
            }
            serviceInstance = serviceInstanceList.get(i % serviceNum);
            System.out.println("当前 atomic 值：" + i);
        } while (!atomicInteger.compareAndSet(i, i + 1));
        return serviceInstance;
    }
}
