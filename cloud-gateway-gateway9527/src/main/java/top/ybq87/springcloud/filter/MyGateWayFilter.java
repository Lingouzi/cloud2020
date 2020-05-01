package top.ybq87.springcloud.filter;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/1
 */
@Slf4j
@Component
public class MyGateWayFilter implements GlobalFilter, Ordered {
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("........filter" + new Date());
        // 如果请求参数 id 为空，返回 not_found
        // String id = exchange.getRequest().getQueryParams().getFirst("id");
        // if (StrUtil.isEmpty(id)) {
        //     exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
        //     return exchange.getResponse().setComplete();
        // }
        return chain.filter(exchange);
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
}
