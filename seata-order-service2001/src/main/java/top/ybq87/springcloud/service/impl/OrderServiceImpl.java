package top.ybq87.springcloud.service.impl;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.ybq87.springcloud.dao.OrderDao;
import top.ybq87.springcloud.domain.Order;
import top.ybq87.springcloud.service.AccountService;
import top.ybq87.springcloud.service.OrderService;
import top.ybq87.springcloud.service.StorageService;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/4
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    
    @Resource
    private OrderDao orderDao;
    
    @Resource
    private StorageService storageService;
    
    @Resource
    private AccountService accountService;
    
    @Override
    public void create(Order order) {
        log.info(">>>>> create start.....");
        // 1、创建订单
        orderDao.create(order);
        // 2、库存扣减
        log.info("开始扣减库存...start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("开始扣减库存...end");
        
        // 3、金额扣减
        log.info("用户扣减金额..start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("用户扣减金额..end");
        
        // 4、订单状态修改
        log.info("修改订单状态  start");
        orderDao.update(order.getUserId(), 0);
        log.info("修改订单状态  end");
        
        log.info(">>>>> create end.....");
    }
    
    @Override
    public void update(Long userId, Integer status) {
        log.info(">>>>> update :" + userId + ";" + status);
        orderDao.update(userId, status);
        
    }
}
