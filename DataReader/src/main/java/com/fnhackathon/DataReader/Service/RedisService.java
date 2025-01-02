package com.fnhackathon.DataReader.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class RedisService {
	
	@Value("${redis.port}")
	private int REDIS_PORT;
	
	@Value("${redis.key}")
	private String REDIS_KEY;
	
	private Jedis getJedis() {
		Jedis jedis=new Jedis("localhost",REDIS_PORT);
		return jedis;
	}

	public ResponseEntity<Map<String, String>> getallOrders() {
		Jedis jedis=getJedis();
		Map<String, String> responses=jedis.hgetAll(REDIS_KEY);
		
		return ResponseEntity.status(200).body(responses);
	}

}
