package top.mixedinfos.redis.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("redisCacheService")
public class RedisCacheService {
    /**
     * 获取缓存
     * @param id
     * @return
     */
    @Cacheable(value="redisCache", key="'redis_user'+#id")
    public User getUser(Long id){
        User user = new User();
        return user;
    }

    /**
     * 新增缓存
     * @param id
     * @return
     */
    @Cacheable(value="reidsCache" , key="'redis_user'+#id")
    public User insertUser(Long id){
        User user = new User();
        user.setId(id);
        user.setAge(28);
        user.setName("秦继源");
        user.setHobby("篮球");
        user.setSex("男");
        user.setId(id);
        return user;
    }

    /**
     * 删除缓存
     * @param id
     * @return
     */
    @CacheEvict(value="redisCache",key="'redis_user' + #id")
    public int deleteUser(Long id){
        return 1;
    }

}
