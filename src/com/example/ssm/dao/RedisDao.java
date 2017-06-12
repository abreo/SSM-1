package com.example.ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.JedisCluster;

@Repository
public class RedisDao {

	@Autowired
    private JedisCluster redis;
	
	public long increment(String key ,int n) {
		long result = redis.incrBy(key, n);
		return result;
	}
	
	public String getHints(String key) {
		return redis.get(key);
	}
	
}
