package com.sow.template2.dao;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class URLShortnerDAO {
	
	private static final Hashtable<String,String> urlMap = new Hashtable<>();
	
	private static final Logger log = LoggerFactory.getLogger(URLShortnerDAO.class);
		
	public void storeShortURL(String shortURL, String originalURL) {
		urlMap.put(shortURL, originalURL);
	}
	
	public String getOriginalURL(String shortURL) {
		return urlMap.get(shortURL);
	}
	
	public String getShortURL(String originalURL) {
		
		printHashMap();
		
		String shortURL = null;
		Set<Entry<String,String>> entrySet = urlMap.entrySet();
		
		for (Entry<String,String> entry : entrySet) {
			if (entry.getValue().equals(originalURL)) {
				shortURL = entry.getKey();
				break;
			}
		}
		
		log.info("from getShortURL for originalURL:" + originalURL + ": returning:" + shortURL);
		
		return shortURL;
	}
	
	private void printHashMap() {
		
		System.out.println("\n------begin printing hashmap-------");
		
		for (String key : urlMap.keySet()) {
			System.out.printf("\nkey:%s: value:%s:", key, urlMap.get(key));
		}
		
		System.out.println("\n------end printing hashmap-------");
		
	}

}
