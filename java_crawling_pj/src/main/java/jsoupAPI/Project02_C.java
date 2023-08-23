package jsoupAPI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_C {
    public static void main(String[] args) {
        Project02_C yes = new Project02_C();
        yes.yes24Book();
    }

    public void yes24Book() {
        try {
            int k = 1;
            for (int i = 1; i <= 8; i++) {
                Document doc = Jsoup.connect("http://www.yes24.com/24/category/bestseller?categorynumber=001&sumgb=09&pagenumber=" + i).get();
                Elements title = doc.select("table.list td.goodsTxtInfo p:eq(0) a:eq(0)");
                Elements Summary = doc.select("table.list td.line p.read");

                for (int j = 0; j < title.size(); j++) {
                    try {
                        Document doc2 = Jsoup.connect("http://www.yes24.com" + title.get(j).attr("href")).get();
                        Element Category = doc2.select("dl.yesAlertDl ul.yesAlertLi li:eq(0) a").get(1);
                        Element Author = doc2.select("span.gd_auth").get(0);
                        Element Pub = doc2.select("div.tp_book span.gd_pub ").get(0);
                        Element Grade = doc2.select("div.tp_book em.yes_b").get(0);

                        System.out.println("순위 : " + k);
                        System.out.println("카테고리 : " + Category.text());
                        System.out.println("책제목: " + title.get(j).text());
                        System.out.println("줄거리 : " + Summary.get(j).text());
                        System.out.println("책 저자 : " + Author.text().split("정보")[0]);
                        System.out.println("출판사 : " + Pub.text());
                        System.out.println("평점 : " + Grade.text());

                        k++;
                        System.out.println("=========================================================");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
