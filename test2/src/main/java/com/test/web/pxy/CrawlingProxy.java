package com.test.web.pxy;

import java.util.HashMap;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component("crawler")
@Lazy
public class CrawlingProxy extends Proxy{
	@Autowired Inventory<HashMap<String, String>> inventory;
	@Autowired Box<String> box;
	
	public Inventory<HashMap<String, String>> engCrawling(String url) {
		url = "https://endic.naver.com/?sLn=kr";
		inventory.clear();
		try {
			Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
			Elements txtOrigin = rawData.select("div[class=\"txt_origin\"] a");
			Elements txtTrans = rawData.select("div[class=\"txt_trans\"]");
			HashMap<String, String> map = null;
			for (int i =0; i<txtOrigin.size(); i++) {
				map = new HashMap<>();
				map.put("Origin", txtOrigin.get(i).text());
				map.put("Trans", txtTrans.get(i).text());
				inventory.add(map);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------크롤링 결과---------");
		inventory.get().forEach(System.out :: println);
		return inventory;
	}
}
