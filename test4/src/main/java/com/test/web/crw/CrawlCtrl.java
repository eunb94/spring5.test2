package com.test.web.crw;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawls")
public class CrawlCtrl {
	

	
	@GetMapping("/naver")
	public ArrayList<String> naver() {
		System.out.println("네이버 클릭");
/*		inventory.clear();*/
		String url = "https://endic.naver.com/?sLn=kr";
	/*	crawler.engCrawling(url).get(); */
		/*System.out.println(inventory.get());*/
		
		return null;
	}
	@GetMapping("/cgv")
	public String cgv() {
		System.out.println("씨지비 클릭");
		return null;
	}
	@GetMapping("/bugs")
	public String bug() {
		System.out.println("벅스 클릭");
		return null;
	}

}
