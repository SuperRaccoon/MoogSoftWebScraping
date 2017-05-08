import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


//built using jsoup, scrapes a specified website for its html content
public class WebScraper {

    public void scrape(String website, String filename) throws Exception {
        System.out.println("scraping " + website + " ...");
        Document document;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            //Get Document object after parsing the html from given url.
            document = Jsoup.connect(website).get();

            String content = document.text();
            //System.out.println("  Title: " + title); //Print title.


            bw.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
        return;
    }


}

