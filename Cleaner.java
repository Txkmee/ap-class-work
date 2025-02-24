import java.util.*;

public class Cleaner {
    private static final ArrayList<String> wordsToRemove = new ArrayList<>(Arrays.asList(
        // Articles
        "a", "an", "the",

        // Pronouns
        "I", "you", "he", "she", "it", "we", "they", 
        "me", "him", "her", "us", "them", "my", "your", 
        "his", "her", "its", "our", "their", "mine", "yours", 
        "his", "hers", "ours", "theirs", "myself", "yourself", 
        "himself", "herself", "itself", "ourselves", "yourselves", 
        "themselves",

        // Common verbs (to be, to have, to do)
        "is", "am", "are", "was", "were", "be", "been", "being", 
        "have", "has", "had", "do", "does", "did", "having", "doing",

        // Modal verbs
        "can", "could", "will", "would", "shall", "should", 
        "may", "might", "must",

        // Adverbs and intensifiers
        "very", "really", "just", "quite", "too", "already", 
        "also", "still", "actually", "never", "always", "often", 
        "sometimes", "usually", "rarely", "seldom", "almost", 
        "even", "only", "especially", "particularly", "basically",

        // Prepositions
        "in", "on", "at", "by", "with", "about", "against", 
        "during", "between", "through", "for", "from", "to", 
        "into", "onto", "upon", "within", "without", "along", 
        "across", "around", "beyond", "under", "over", "above", 
        "below", "near", "of", "off", "out", "up", "down",

        // Conjunctions
        "and", "or", "but", "so", "nor", "yet", "because", 
        "although", "though", "while", "since", "until", "unless", 
        "whether", "while", "whereas", "if", "else", "when", 
        "where", "why", "how",

        // Demonstratives
        "this", "that", "these", "those",

        // Quantifiers
        "each", "every", "either", "neither", "some", "any", 
        "few", "many", "several", "all", "much", "more", "most", 
        "another", "other", "no", "none", "both", "such",

        // Comparative and superlative adjectives
        "taller", "smaller", "bigger", "larger", 
        "shorter", "longer", 
        

        // Miscellaneous
        "as", "like", "than", "not", "now", "then", "here", 
        "there", "where", "when", "why", "how", "what", "who", 
        "whom", "whose", "which", "whatever", "whoever", "whichever", 
        "anyone", "anything", "something", "everything", "nothing", 
        "someone", "somebody", "everyone", "everybody", "no one", 
        "nobody", "anybody", "anywhere", "somewhere", "everywhere", 
        "nowhere", "anyway", "somehow", "somewhat", "anyhow", 
        "anyways", "anytime", "sometime", "sometimes", "meanwhile", 
        "therefore", "however", "otherwise", "instead", "perhaps", 
        "maybe", "almost", "enough", "indeed", "rather", "quite", 
        "together", "apart", "alone", "along", "away", "back", 
        "forward", "further", "furthermore", "moreover", "nevertheless", 
        "nonetheless", "otherwise", "similarly", "subsequently", 
        "thereby", "thus", "whereas", "whereby", "wherein", "wherever",

        //generic site words
         "skip", "content", "home", "news", "sport", "business", "innovation", 
        "culture", "arts", "travel", "earth", "audio", "video", "live", "weather", "uk", 
        "politics", "england", "ireland", "scotland", "wales", "africa", "asia", 
        "china", "india", "australia", "europe", "latin", "america", "middle", "east", 
        "pictures", "bbc", "indepth", "verify", "executive", "lounge", "technology", 
        "future", "science", "health", "artificial", "intelligence", "ai", "mind", "film", 
        "tv", "music", "art", "design", "style", "books", "entertainment", "motion", 
        "destinations", "antarctica", "pacific", "caribbean", "bermuda", "central", 
        "north", "south", "worlds", "table", "experiences", "adventures", 
        "specialist", "natural", "wonders", "climate", "solutions", "sustainable", 
        "green", "living", "podcasts", "radio", "faqs", "newsletters", "shop", 
        "languages", "follow", "terms", "use", "privacy", "policy", "cookies", 
        "accessibility", "help", "contact", "advertise", "share", "sell", "info", 
        "technical", "support", "copyright", "responsible", "external", "sites", 
        "linking", "approach", "read"

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
