package top.mixedinfos.redis.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于测试redis缓存数据
 */
@RestController
@RequestMapping("/cache")
public class RedisCacheController {
    @Autowired
    private RedisCacheService redisCacheService;

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser(@RequestParam Long id){
        return redisCacheService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public void insertUser(@RequestParam Long id){
         redisCacheService.insertUser(id);
    }
    @RequestMapping("/deleteUser")
    public void deleteUser(@RequestParam Long id){
        redisCacheService.deleteUser(id);
    }

}
