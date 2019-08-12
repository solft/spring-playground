package hansol.springredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/a")
    public String test() {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("name", "hansol");
        values.set("framework", "spring");
        values.set("message", "hello world");

        return values.get("name");
    }
}
