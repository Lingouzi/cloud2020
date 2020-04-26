package top.ybq87.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.ybq87.springcloud.entities.Payment;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/4/25
 */
@Mapper
public interface IPaymentDao {
    
    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);
    
    /**
     * 读取
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
