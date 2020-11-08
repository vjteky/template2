package com.sow.template2.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sow.template2.service.URLShorternerService;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@RestController
@RequestMapping(path = "/api/v1")
public class URLShortnerController {
	
	@Autowired
	private URLShorternerService urlShorternerService;
	
	private static final Logger logger = LoggerFactory.getLogger(URLShortnerController.class);
	
	@Timed(value = "shortLink.getTime")
	@RequestMapping(value = "/shortLink", method = RequestMethod.GET)  
	public String getShortURL(@RequestParam(value = "url") String url) {
		
		increaseCount("shortLink.getCounter");
		
		logger.info("entered getShortURL");
		
		String shortURL = urlShorternerService.getShortURL(url);
		
		logger.info("from getShortURL for url:" + url + " retiurning:" + shortURL);
		
		return shortURL;
	}
	
	@Timed(value = "shortLink.createTime")
	@RequestMapping(value = "/shortLink", method = RequestMethod.POST)  
	public Map<String, String> createShortURL(@RequestBody String url) {
		
		increaseCount("shortLink.createCounter");
		
		logger.info("entered createShortURL");
		Map<String, String> resultMap = new HashMap<>();
		try {
			String shortURL = urlShorternerService.generateShortURL(url);
			resultMap.put(url, shortURL);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return resultMap;
	}
	
	private void increaseCount(String counterName) {
		 //Counter class stores the measurement name and the tags and
		 //their values
	    Counter counter = Metrics.counter(counterName);   
	    counter.increment();
	}

}
