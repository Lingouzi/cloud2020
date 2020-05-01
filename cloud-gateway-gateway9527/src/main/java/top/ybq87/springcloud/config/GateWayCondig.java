package top.ybq87.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 编码方式使用 gateway，将访问 http://localhost:9527/guonei 转发到访问 https://news.baidu.com/guonei
 *
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/1
 */
@Configuration
public class GateWayCondig {
    
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        Builder routes = builder.routes();
        routes.route("payment-routh3", r -> r.path("/guonei").uri("https://news.baidu.com/guonei"));
        return routes.build();
    }
}
