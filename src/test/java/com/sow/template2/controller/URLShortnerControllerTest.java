package com.sow.template2.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sow.template2.service.URLShorternerService;


@WebMvcTest(URLShortnerController.class)
public class URLShortnerControllerTest {
	
	@Autowired
    private MockMvc mvc;
 
	@MockBean
	private URLShorternerService urlShorternerService;
	
	@Test
	public void createShortURLTest()
	  throws Exception {
		
		String originalURL = "http://localhost:8080/my-very-long-url";
		String shortURL = "abcdefgh";
	 
		when(urlShorternerService.generateShortURL(originalURL)).thenReturn(shortURL);
	 
	    mvc.perform(post("/api/v1/shortLink")
	      .content(originalURL)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath(originalURL).value(shortURL));     
	}
	
	@Test
	public void getShortURLTest()
	  throws Exception {
		
		String originalURL = "http://localhost:8080/my-very-long-url";
		String shortURL = "abcdefgh";
	 
		when(urlShorternerService.getShortURL(originalURL)).thenReturn(shortURL);
	 
	    mvc.perform(get("/api/v1/shortLink")
	      .param("url", originalURL)
	      .contentType(MediaType.TEXT_PLAIN))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
	      .andExpect(content().string(containsString(shortURL)));     
	}

}
