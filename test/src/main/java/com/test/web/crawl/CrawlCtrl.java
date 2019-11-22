package com.test.web.crawl;

import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@Lazy
@RequestMapping("/crawls")
public class CrawlCtrl {
	
	@GetMapping("/naver")
	public String naver() {
		System.out.println("네이버 컨트롤러");
		return null;
		
	}
	@GetMapping("/cgv")
	public String cgv() {
		System.out.println("씨지비 컨트롤러");
		return null;
		
	}
	@GetMapping("/bugs")
	public String bugs() {
		System.out.println("벅스 컨트롤러");
		return null;
		
	}
}
