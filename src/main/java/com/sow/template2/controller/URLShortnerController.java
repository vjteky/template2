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



@RestController
@RequestMapping(path = "/api/v1")
public class URLShortnerController {
	
	@Autowired
	private URLShorternerService urlShorternerService;
	
	private static final Logger logger = LoggerFactory.getLogger(URLShortnerController.class);
	
	@RequestMapping(value = "/shortLink", method = RequestMethod.GET)  
	public String getShortURL(@RequestParam(value = "url") String url) {
		
		logger.info("entered getShortURL");
		
		String shortURL = urlShorternerService.getShortURL(url);
		
		logger.info("from getShortURL for url:" + url + " retiurning:" + shortURL);
		
		return shortURL;
	}
	
	@RequestMapping(value = "/shortLink", method = RequestMethod.POST)  
	public Map<String, String> createShortURL(@RequestBody String url) {
		
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

}
