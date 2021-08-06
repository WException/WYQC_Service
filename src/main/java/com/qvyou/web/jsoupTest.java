package com.qvyou.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class jsoupTest {
    public static void main(String[] args) {
        String url3 = "https://www.tianqi.com/jinan/";
        try {
            // 获取要爬取的网页Document
            Document doc2 = Jsoup.parse(new URL(url3), 30000);
            // 获取需要的节点
            Element now = doc2.getElementsByClass("now").first().child(0);
            System.out.println(now.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
