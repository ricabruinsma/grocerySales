
package edu.matc.jsoupexample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.URL;


public class Scraper
{
    public static void main( String[] args ) throws IOException {

        Document doc = Jsoup.parse(
                new URL("https://www.hy-vee.com/deals/CD1316/Hot-Deals"),
                30000
        );
        String title = doc.title();
        System.out.println("title is " + title);
    }
}

