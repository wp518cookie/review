package test.redis;


import base.BaseJUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * Created by Administrator on 2018/3/29.
 */
public class TestRedis extends BaseJUnitTest {
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private Jedis jedis;
    @Test
    public void testJedis() {
        String result = jedisCluster.get("hello");
        System.out.println(result);
    }
}
