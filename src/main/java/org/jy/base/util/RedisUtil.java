package org.jy.base.util;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Service
public class RedisUtil {
    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        return operations.get(key);
    }

    public Object get(byte[] key) {
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        return operations.get(key);
    }
    public Object get(Serializable key) {
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        return operations.get(key);
    }

    /**
     * 获取所有前缀相同的key 信息
     * @param prefix
     * @return
     */
    public  Set<Serializable> getPreKeys(String prefix){
        Set<Serializable> keys = redisTemplate.keys(prefix);
        if (keys.size() > 0)
            return keys;
        return null;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 存储REDIS队列 顺序存储
     * @param key
     * @param value
     * @return
     */
    public boolean setList(final String key, Object value) {
        boolean result = false;
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            operations.leftPush(key,value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取list 队列的数据
     * @param key
     * @return
     */
    public Object getListBykey(final String key) {
        ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
        return  operations.rightPop(key);
    }


    public Object getListSize(final String key) {
        ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
        return  operations.size(key);
    }






}
