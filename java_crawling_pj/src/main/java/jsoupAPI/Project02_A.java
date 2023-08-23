package jsoupAPI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_A {
    public static void main(String[] args) {
        // Jsoup API
        String url="https://sports.news.naver.com/index.nhn";
        Document doc=null;
        try {
            doc= Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Elements element=doc.select("ul.today_list");

        Elements element2=doc.select("div.aside_head");



        for(Element el : element.select("li")) {
            System.out.println(el.text());
        }
        System.out.println("===============================");
    }
    }

