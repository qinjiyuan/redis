package top.mixedinfos.redis.jedis_lua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class LuaDemo{
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    private DefaultRedisScript<List> getRedisScript;

    @PostConstruct
    public DefaultRedisScript<List> defaultRedisScript() {
        getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(List.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("demo.lua")));
        return getRedisScript;
    }

    /**
     * redis 运行lua脚本
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/doLuaScripts")
    public List doLuaScripts(@RequestParam String key ,@RequestParam String value) {
        /**
         * List设置lua的KEYS
         */
        List<String> keyList = new ArrayList();
        keyList.add(key);
        keyList.add(value);

        List result = redisTemplate.execute(getRedisScript,keyList);
        return result;
    }
    @RequestMapping("/addKeyToRedis")
    public void addKeyToRedis(@RequestParam("key")String key ,@RequestParam("value")String value){
        redisTemplate.opsForValue().set(key,value);
    }

    @RequestMapping("/testLua")
    public String testLua(){
        DefaultRedisScript<String > rs = new DefaultRedisScript<>();
        rs.setScriptText("return 'Hello Redis'");
        rs.setResultType(String.class);
        RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
        String str = (String)redisTemplate.execute(rs,redisSerializer,redisSerializer,null);
        return str;
    }




}
