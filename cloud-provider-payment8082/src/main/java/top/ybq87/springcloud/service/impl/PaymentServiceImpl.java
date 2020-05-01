package top.ybq87.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ybq87.springcloud.dao.IPaymentDao;
import top.ybq87.springcloud.entities.Payment;
import top.ybq87.springcloud.service.IPaymentService;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/25
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    
    @Autowired
    private IPaymentDao paymentDao;
    
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
    
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
