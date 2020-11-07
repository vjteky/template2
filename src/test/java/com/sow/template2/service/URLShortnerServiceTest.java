package com.sow.template2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.sow.template2.dao.URLShortnerDAO;


//@SpringBootTest(classes = {URLShorternerService.class, URLShortnerDAO.class})
@SpringBootTest
public class URLShortnerServiceTest {
	
	@Autowired
	private URLShorternerService urlShorternerService;
	
	@Test
	public void testGetShortURL() {
		
		String url = "https://www.t-mobile.com/cell-phone/apple-iphone-12-mini?icid=MGPO_MTW_P_20APPLNPI_TYW4T0QSXRP059MLJ22706";
			
		String shortURL1 = urlShorternerService.generateShortURL(url);
		
		assertNotNull(shortURL1);
		
		System.out.printf("\n Original URL:%s ShortURL:%s", url, shortURL1);
		
		String shortURL2 = urlShorternerService.generateShortURL(url);
		assertEquals(shortURL1, shortURL2);
		
	}

}
