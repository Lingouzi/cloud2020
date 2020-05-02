package top.ybq87.springcloud.service;

import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author ly
 * @blog http://www.ybq87.top
 * @github https://github.com/Lingouzi
 * @email 664162337@qq.com
 * @wechat ly19870316 / 公众号：林子曰
 * @date 2020/5/2
 */
@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements IMessageProviderService {
    
    @Resource
    private MessageChannel output;
    
    @Override
    public String send() {
        String simpleUUID = IdUtil.simpleUUID();
        boolean send = output.send(MessageBuilder.withPayload(simpleUUID).build());
        System.out.println("send id:" + simpleUUID);
        return "是否发送：" + send;
    }
}
