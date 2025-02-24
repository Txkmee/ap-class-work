import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            //Fetch and parse HTML from a website
            Document doc = Jsoup.connect("https://www.bbc.com/news/articles/c75wqr0k3dyo").get();
            //System.out.println("Text: " + doc.text());
            System.out.println(Cleaner.textCleaner(doc.text()));
            } catch (Exception e) {
            e.printStackTrace();
            }

        
    }
}
