package com.sow.template2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sow.template2.dao.URLShortnerDAO;

@TestInstance(Lifecycle.PER_CLASS)
public class URLShortnerServiceIntegrationTest {
	
	@Mock
    private URLShortnerDAO URLShorternerDAO;
	
	@InjectMocks
    private URLShorternerService urlShorternerService;
	
	@BeforeAll
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGetShortURL() {
		
		String url = "https://www.t-mobile.com/cell-phone/apple-iphone-12-mini?icid=MGPO_MTW_P_20APPLNPI_TYW4T0QSXRP059MLJ22706";
			
		
		when(URLShorternerDAO.getShortURL(url)).thenReturn("abcdefgh");
		
		String shortURL1 = urlShorternerService.generateShortURL(url);
		
		assertNotNull(shortURL1);
		
		System.out.printf("\n Original URL:%s ShortURL:%s", url, shortURL1);
		
		String shortURL2 = urlShorternerService.generateShortURL(url);
		assertEquals(shortURL1, shortURL2);
		
	}

}
