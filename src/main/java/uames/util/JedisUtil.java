package uames.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import controller.DefaultConfig;

public class JedisUtil {
    private static JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(DefaultConfig.getIntPropery("redis.pool.maxActive"));
        config.setMaxIdle(DefaultConfig.getIntPropery("redis.pool.maxIdle"));
        config.setMaxWait(DefaultConfig.getLongPropery("redis.pool.maxWait"));
        config.setTestOnBorrow(DefaultConfig.getBoolPropery("redis.pool.testOnBorrow"));
        config.setTestOnReturn(DefaultConfig.getBoolPropery("redis.pool.testOnReturn"));
        pool = new JedisPool(config, DefaultConfig.getPropery("redis.ip"), DefaultConfig.getIntPropery("redis.port"));
    }

    /**
     * 向缓存中添加数据
     * @param key
     * @param value
     */
    public static void put(String key, String value) {
        Jedis jedis = pool.getResource();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.returnResource(jedis); // 链接池中回收资源
        }
    }

    /*
     * 根据键值获取资源
     */
    public static String get(String key) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            pool.returnResource(jedis);
        }
    }

    /*
     * 根据键值从缓存中删除数据
     */
    public static void delete(String... key) {
        Jedis jedis = pool.getResource();
        try {
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.returnResource(jedis);
        }
    }

}
