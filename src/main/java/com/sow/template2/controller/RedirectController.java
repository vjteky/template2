package com.sow.template2.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sow.template2.service.URLShorternerService;


@Controller
public class RedirectController {
	
	@Autowired
	private URLShorternerService urlShorternerService;
	
	private static final Logger log = LoggerFactory.getLogger(RedirectController.class);
	
	@RequestMapping(value = "/*", method = RequestMethod.GET)  
	public String redirect(HttpServletRequest request) {
		
		log.info("in redirect");
		
		String test1 = request.getRequestURI();
		
		log.info("in redirect test1:" + test1);
		
		
		String redirectUrl = urlShorternerService.getOriginalURL(test1.replace("/", ""));
		
		//String redirectUrl = "http://www.yahoo.com";
		return "redirect:" + redirectUrl;
	}

}
