package com.anthonypulsone.yelpfusionapiproxycache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class YelpFusionApiProxyCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(YelpFusionApiProxyCacheApplication.class, args);
	}

}
