import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Rss {

/*    private final static String RSS_URL = "https://blog.opsta.cn/feed.xml";

    public void test() throws MalformedURLException {
        //URL feedUrl = new URL(String.format(RSS_URL, symbol));
        //null 代表header
        URL feedUrl = new URL(String.format(RSS_URL, null));
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (feed == null) {
            //log.warn("syndFeed is null, symbol:{}", symbol);
            return;
        }
        List<SyndEntry> list = feed.getEntries();
        for (SyndEntry entry : list) {
            System.out.println(entry.getTitle() + "-" + entry.getUpdatedDate() + "-" + entry.getLink());
        }

    }*/


   /* public static void main(String[] args) {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        try {
            String url = "https://blog.opsta.cn/feed.xml";

            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                for (SyndEntry entry : feed.getEntries()) {
                    System.out.println(entry.getTitle());
                    System.out.println(entry.getUri());
                    System.out.println(sdf.format(entry.getPublishedDate()));
                    System.out.println(sdf.format(entry.getUpdatedDate()));
                    System.out.println("***********************************");
                }

                System.out.println("Done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
   @Test
   public void getSource() throws IOException {

      Element content = Jsoup.connect("http://blog.opsta.cn/") .data("query", "Java")
                    .userAgent("Chrome")
                    .get();
      Document doc = Jsoup.parse(String.valueOf(content));
      Element body = doc.body();
      System.out.println(body);

   }




  /*@Test
    public void getSource() {
        String url = "https://blog.opsta.cn/feed";
        String html = new String();
        HttpGet httpget = new HttpGet(url);     //创建Http请求实例，URL 如：https://cd.lianjia.com/
        // 模拟浏览器，避免被服务器拒绝，返回返回403 forbidden的错误信息
        httpget.setHeader("User-Agent",
                      "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");

        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();   // 使用默认的HttpClient
        try {
            response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {     // 返回 200 表示成功
                html = EntityUtils.toString(response.getEntity(), "utf-8");     // 获取服务器响应实体的内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Object test=getImgSrc(html);
        System.out.println(test);
    }*/



}