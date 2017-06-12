package com.example.ssm.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.example.ssm.entities.User;
import com.example.ssm.util.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer(); //借用spring_data_redis.jar中的JdkSerializationRedisSerializer.class
//connection.set(serializer.serialize(key), serializer.serialize(value)); //利用其序列化方法将数据写入redis服务的缓存中


public class RedisCache implements Cache {

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	private static JedisPool pool;

	public static void setPool(JedisPool pool) {
		RedisCache.pool = pool;
	}
	
	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
//		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
		this.id = id;
		if (pool != null) {
			return;
		}
		// 初始化redis连接池
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-redis.xml");
		pool = (JedisPool)context.getBean("jedisPool");
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void putObject(Object key, Object value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
		} catch (Exception e) {
			throw new RuntimeException("Redis出现错误！", e);
		} finally {
			close(jedis);
		}
	}

	@Override
	public Object getObject(Object key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			byte[] result = SerializeUtil.serialize(key);
			byte[] data = jedis.get(result);
			if (data == null || data.length <= 0) {
				return null;
			}
			return SerializeUtil.unserialize(data);
		} catch (Exception e) {
			throw new RuntimeException("Redis出现错误！", e);
		} finally {
			close(jedis);
		}
	}

	@Override
	public Object removeObject(Object key) {
		Jedis jedis = null;
		Object object = null;
		try {
			jedis = pool.getResource();
			byte[] data = jedis.get(SerializeUtil.serialize(key));
			if (data != null && data.length > 0) {
				object = SerializeUtil.unserialize(data);
				jedis.del(SerializeUtil.serialize(key));
			}
		} catch (Exception e) {
			throw new RuntimeException("Redis出现错误！", e);
		} finally {
			close(jedis);
		}
		return object;
	}

	@Override
	public void clear() {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.flushDB();
		} catch (Exception e) {
			throw new RuntimeException("Redis出现错误！", e);
		} finally {
			close(jedis);
		}
	}

	@Override
	public int getSize() {
		int size = 0;
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			size = NumberUtils.toInt(jedis.dbSize() + "");
		} catch (Exception e) {
			throw new RuntimeException("Redis出现错误！", e);
		} finally {
			close(jedis);
		}
		return size;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	private void close(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
}
