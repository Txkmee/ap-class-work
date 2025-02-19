import java.util.*;

public class Cleaner {
    private static ArrayList<String> sentences = new ArrayList<String>();

    private static ArrayList<String> wordsToRemove = new ArrayList<>(Arrays.asList(
        "a", "an", "the", "I", "you", "he", "she", "it", "we", "they", 
        "him", "her", "them", "us", "yours", "theirs", "is", "am", "are", 
        "was", "were", "be", "been", "being", "have", "has", "had", "do", 
        "does", "did", "very", "really", "just", "quite", "too", "already", 
        "also", "still", "actually", "never", "always", "often", "in", "on", 
        "at", "by", "with", "about", "against", "during", "between", "through", 
        "for", "from", "or", "and", "but", "so", "nor", "yet", "because", 
        "although", "before", "after", "which", "who", "whom", "that",
        "this", "that", "these", "those", "my", "your", "his", "her", "its", 
        "our", "their", "which", "what", "whose", "better", "worse", "taller", 
        "smaller", "more", "less", "each", "every", "either", "neither", "some", 
        "any", "few", "many", "several", "all", "much", "more", "most", "another", 
        "other", "no"
    ));

    private static ArrayList<String> badWords = new ArrayList<> (Arrays.asList(
        "bad", "hold back", "trash", "incoherent", "ass", "mid", "shit", "dumb", 
        "disruptive", "vain"
    ));

    private static ArrayList<String> goodWords = new ArrayList<> (Arrays.asList(
        "good", "excellent", "amazing", "wonderful", "fantastic", "outstanding",
        "great", "positive", "impressive", "superb", "brilliant", "incredible", 
        "awesome", "remarkable", "marvelous", "successful", "inspirational",
        "motivating", "exceptional", "extraordinary", "phenomenal", "outstanding",
        "uplifting", "productive", "energetic", "joyful", "cheerful"
    ));
    public static ArrayList<String> arrayer(String text) {
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");
        text = text.toLowerCase();
        ArrayList<String> textArray = new ArrayList<> (Arrays.asList(text.split(" ")));
        
        return textArray;   
    }

    public static ArrayList<String> textCleaner(String text) {
        ArrayList<String> arrayed = arrayer(text);
        for (int i = 0; i < arrayed.size(); i++) {
            String arrayedText = arrayed.get(i);
            for (int j = 0; j < wordsToRemove.size(); j++) {
                String wordChecked = wordsToRemove.get(j);

                if (arrayedText.equals(wordChecked)) {
                    arrayed.remove(i);
                    i--;
                }
            }
        }

        return arrayed;
    }
}
