package com.sow.template2.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.template2.dao.URLShortnerDAO;

@Service
public class URLShorternerService {
	
	@Autowired
	private URLShortnerDAO urlShortnerDAO;
	
	private final char[] allowedChars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','1','2','3',
											'4','5','6','7','8','9','0'}; 
	
	private final int URL_LENGTH = 8;
	
	private static final Logger log = LoggerFactory.getLogger(URLShorternerService.class);
	
	public String generateShortURL(String originalURL) {
		
		log.info("entered generateShortURL");
		
		String shortURL = urlShortnerDAO.getShortURL(originalURL);
		
		if (shortURL == null) {
			shortURL = createShortURL(originalURL);
			urlShortnerDAO.storeShortURL(shortURL, originalURL);
		}
		
		log.info("in generateShortURL - url generated successfully");
		
		return shortURL;
	}
	
	public String getOriginalURL(String shortURL) {
		return urlShortnerDAO.getOriginalURL(shortURL);
	}
	
	public String getShortURL(String originalURL) {
		return urlShortnerDAO.getShortURL(originalURL);
	}
	
	private String createShortURL(String url) {
		StringBuilder shortURL = new StringBuilder();
		int random;
		Random  randomNumGenerator = new Random();
		for (int i=0; i<URL_LENGTH; i++) {
			random = randomNumGenerator.nextInt(URL_LENGTH);
			shortURL.append(allowedChars[random]);
		}
		
		return shortURL.toString(); 
	}

}
