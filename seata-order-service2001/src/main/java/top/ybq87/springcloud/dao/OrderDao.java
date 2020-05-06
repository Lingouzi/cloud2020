package top.ybq87.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.ybq87.springcloud.domain.Order;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/4
 */
@Mapper
public interface OrderDao {
    
    void create(Order order);
    
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}