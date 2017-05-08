import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;

/**
 * Created by zekun on 5/8/17.
 */
public class Main {
    public static void main(String args[]){
        //SPECIFY NUMBER OF ITEMS TO RETURN
        int numberEntries = 10;
        //insert websites to scrape, delineated by a comma
        String websites = "https://en.wikipedia.org/wiki/The_Interview "
                +"http://www.imdb.com/title/tt2788710/ "
                +"http://www.theinterview-movie.com/ "
                +"http://www.bbc.com/news/world-asia-30608179 "
                +"https://www.rottentomatoes.com/m/the_interview_2014/ "
                +"http://www.metacritic.com/movie/the-interview ";




        WebScraper webscraper = new WebScraper();
        ArrayList<String> textFiles = new ArrayList<String>();

        String[] delimitedWebsites = websites.split(" ");;//we assume words are separated by grammar marks

        //scrape websites and store content in textFile
        for(int i = 0; i < delimitedWebsites.length; i++) {
            String filename = "webtext" + Integer.toString(i) + ".txt";
            textFiles.add(filename);
            String url = delimitedWebsites[i];
            try{
                webscraper.scrape(url, filename);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        //process textFiles and remove them
        TextProcessor myProcessor = new TextProcessor();
        myProcessor.processAndPrintText(textFiles, numberEntries);


        //clean up text files used for storage
        for(String filename: textFiles){
            String filePath = "./" + filename;
            new File(filePath).delete();

        }





    }

}
