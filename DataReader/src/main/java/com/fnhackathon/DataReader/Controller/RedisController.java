package com.fnhackathon.DataReader.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnhackathon.DataReader.Service.RedisService;

@RestController
@RequestMapping("/api")
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	@GetMapping("/getOrders")
	public String Datareader() {
		try {
			ResponseEntity<Map<String,String>> fetched=redisService.getallOrders();
			return fetched.getBody().toString();
		}catch(Exception e) {
			return e.toString();
		}
	}
	
}
