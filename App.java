import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {
    public static void main(String[] args) throws Exception {
        String bullyReview = "Perm is not a good guy, come back from AP field trip pls good bad ok fine good amazing exeptional outstanding bad bad bad bad";
        ArrayList<String> qwe = new ArrayList();
        qwe.add("Perm is not a good guy, come back from AP field trip pls good bad ok fine good amazing exeptional outstanding bad bad bad bad");
        qwe.add("Perm is not a good guy, come back from AP field trip pls good bad ok fine good amazing exeptional outstanding bad bad bad bad");
        qwe.add("Perm is not a good guy, come back from AP field trip pls good bad ok fine good amazing exeptional outstanding bad bad bad bad");
        qwe.add("Perm is not a good guy, come back from AP field trip pls good bad ok fine good amazing exeptional outstanding bad bad bad bad bad bad bad");
        qwe.add("Perm is not a good guy, come back from AP field trip pls good bad ok fine good amazing exeptional outstanding bad bad bad bad");

        // try {
        //     //Fetch and parse HTML from a website
        //     Document doc = Jsoup.connect("https://www.pcgamer.com/games/assassins-creed/i-played-6-hours-of-assassins-creed-shadows-and-folks-i-think-this-one-was-worth-the-wait/").get();
        //     //System.out.println("Text: " + doc.text());
        //     System.out.println(Cleaner.textCleaner(doc.text()));
        //     ArrayList<String> fortnite= new ArrayList<String>(Cleaner.textCleaner(doc.text()));
        //     System.out.println(Cleaner.countBadWords(fortnite));
        //     } catch (Exception e) {
        //     e.printStackTrace();
        //     }

        Document pcGamerArticle = Jsoup.connect("https://www.pcgamer.com/games/assassins-creed/i-played-6-hours-of-assassins-creed-shadows-and-folks-i-think-this-one-was-worth-the-wait/").get();
        Document ignArticle = Jsoup.connect("https://www.ign.com/articles/assassins-creed-shadows-is-not-the-ninja-splinter-cell-game-i-hoped-for").get();
        qwe.add(pcGamerArticle.text());
        qwe.add(ignArticle.text());

        Cleaner.textCleaner(qwe);


        
        
    }
}
