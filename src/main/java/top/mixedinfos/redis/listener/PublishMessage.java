package top.mixedinfos.redis.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishMessage {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/publishMessage")
    public void sendMessage(@RequestParam  String channel, @RequestParam String message){
        redisTemplate.convertAndSend(channel,message);
    }
}
