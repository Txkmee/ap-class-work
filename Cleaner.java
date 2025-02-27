import java.util.*;

public class Cleaner {
    private static final ArrayList<String> wordsToRemove = new ArrayList<>(Arrays.asList(
        //random stuff
        "canada", "australia", "miniitx", "motherboards", "gaming", "show", "signup", "guideline", "guide", "community",
        "affiliate", "links", "meet", "team", "try", "subscription", "delivered", "door", "device", "from3599", "view", "avowed", "kingdom", "come", "deliverance", "civ", "nvidia", "rtx", "marvel",
        "rivals", "reviews", "mag", 
        
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
        "as", "like", "than", "now", "then", "here", 
        "there", "where", "when", "why", "how", "what", "who", 
        "whom", "whose", "which", "whatever", "whoever", "whichever", 
        "anyone", "anything", "something", "everything", "someone", 
        "anywhere", "somewhere", "everywhere", 
        "anyway", "somehow", "somewhat", "anyhow", 
        "anyways", "anytime", "sometime", "sometimes", "meanwhile", 
        "therefore", "however", "otherwise", "instead", "perhaps", 
        "maybe", "almost", "enough", "indeed", "rather", "quite", 
        "together", "apart", "along", "away", "back", 
        "forward", "further", "furthermore", "moreover", "nevertheless", 
        "nonetheless", "otherwise", "similarly", "subsequently", 
        "thereby", "thus", "whereas", "whereby", "wherein", "wherever",

        //generic site words
         "skip", "content", "home", "news", "sport", "business", "innovation", 
        "culture", "arts", "travel", "earth", "audio", "video", "live", "weather", "uk", 
        "politics", "england", "ireland", "scotland", "wales", "africa", "asia", 
        "pictures", "indepth", "verify", "executive", "lounge", "technology", 
        "future", "science", "health", "artificial", "intelligence", "mind", "film", 
        "tv", "music", "art", "design", "style", "books", "entertainment", "motion", 
        "destinations", "worlds", "table", "experiences", "adventures", 
        "specialist", "natural", "wonders", "climate", "solutions", "sustainable", 
        "green", "living", "podcasts", "radio", "faqs", "newsletters", "shop", 
        "languages", "follow", "terms", "use", "privacy", "policy", "cookies", 
        "accessibility", "help", "contact", "advertise", "share", "sell", "info", 
        "technical", "support", "copyright", "responsible", "external", "sites", 
        "linking", "approach", "read", "pc", "gamer", "main", "open", "menu", "close", "global",
        "authority", "search", "games", "subscribe", "game", "hardware", "magazine", "edition",
        "software", "movies", "movie", "forum", "industry", "issues", "issue", "newsletter"

    ));

    private static ArrayList<String> badWords = new ArrayList<> (Arrays.asList(
        "bad", "hold back", "trash", "incoherent", "ass", "mid", "shit", "dumb", 
    "disruptive", "vain", "useless", "garbage", "awful", "terrible", "horrible", 
    "stupid", "nonsense", "pointless", "ridiculous", "lame", "crap", "foolish", 
    "pathetic", "worthless", "broken", "messy", "chaotic", "annoying", "irritating", 
    "frustrating", "boring", "unbearable", "unacceptable", "disappointing", "mediocre", 
    "overrated", "underwhelming", "sloppy", "half-baked", "lazy", "incompetent", 
    "clumsy", "awkward", "cringe", "embarrassing", "toxic", "nasty", "mean", 
    "rude", "selfish", "arrogant", "ignorant", "hypocritical", "manipulative", 
    "deceptive", "dishonest", "fake", "pretentious", "overhyped", "overpriced", 
    "scam", "rip-off", "waste", "failure", "flop", "disaster", "trainwreck", 
    "dumpster fire", "hot mess", "clusterfuck", "bullshit", "cringe-worthy", 
    "eye-rolling", "facepalm", "yikes", "oof", "cringey", "painful", "unfunny", 
    "uninspired", "derivative", "cliché", "predictable", "bland", "soulless", 
    "empty", "shallow", "meaningless", "forgettable", "regrettable", "unoriginal", 
    "repetitive", "tedious", "monotonous", "exhausting", "draining", "stressful", 
    "infuriating", "maddening", "insufferable", "unpleasant", "miserable", 
    "depressing", "hopeless", "grim", "bleak", "dreadful", "horrendous", 
    "atrocious", "abysmal", "appalling", "revolting", "disgusting", "vile", 
    "repulsive", "offensive", "insulting", "demeaning", "degrading", "humiliating", 
    "shameful", "disgraceful", "embarrassment", "letdown", "fiasco", "debacle", 
    "catastrophe", "calamity", "nightmare", "hellish", "grueling", "agonizing", 
    "torturous", "unbearable", "unendurable", "unrelenting", "relentless", 
    "merciless", "cruel", "harsh", "brutal", "savage", "vicious", "ruthless", 
    "cutthroat", "backstabbing", "two-faced", "fake", "phony", "fraud", "liar", 
    "cheat", "scammer", "thief", "crook", "villain", "monster", "demon", 
    "devil", "beast", "savage", "barbaric", "inhumane", "heartless", "soulless", 
    "cold", "callous", "indifferent", "apathetic", "uncaring", "self-centered", 
    "egotistical", "narcissistic", "entitled", "spoiled", "bratty", "childish", 
    "immature", "petty", "spiteful", "vengeful", "bitter", "resentful", 
    "grudge-holding", "pessimistic", "cynical", "defeatist", "hopeless", 
    "despairing", "despondent", "melancholic", "gloomy", "dreary", "dismal", 
    "bleak", "dark", "shadowy", "sinister", "malevolent", "malicious", 
    "wicked", "evil", "sinful", "corrupt", "depraved", "degenerate", 
    "perverse", "twisted", "disturbed", "unhinged", "deranged", "psychotic", 
    "maniacal", "insane", "crazy", "lunatic", "mad", "bonkers", "nuts", 
    "batty", "loony", "wacko", "cuckoo", "bananas", "absurd", "preposterous", 
    "ludicrous", "outrageous", "unbelievable", "unthinkable", "unimaginable", 
    "inconceivable", "impossible", "hopeless", "lost", "doomed", "damned", 
    "cursed", "hexed", "jinxed", "unlucky", "unfortunate", "ill-fated", 
    "star-crossed", "tragic", "sad", "miserable", "wretched", "pitiful", 
    "pathetic", "sorry", "lamentable", "regrettable", "unfortunate", 
    "unhappy", "sorrowful", "grieving", "mournful", "heartbroken", "devastated", 
    "crushed", "destroyed", "ruined", "shattered", "broken", "defeated", 
    "beaten", "overwhelmed", "powerless", "helpless", "hopeless", "desperate", 
    "despairing", "anguished", "tormented", "tortured", "suffering", "agonized", 
    "miserable", "wretched", "unhappy", "sad", "depressed", "despondent", 
    "melancholic", "gloomy", "dreary", "dismal", "bleak", "dark", "shadowy", 
    "sinister", "malevolent", "malicious", "wicked", "evil", "sinful", 
    "corrupt", "depraved", "degenerate", "perverse", "twisted", "disturbed", 
    "unhinged", "deranged", "psychotic", "maniacal", "insane", "crazy", 
    "lunatic", "mad", "bonkers", "nuts", "batty", "loony", "wacko", "cuckoo", 
    "bananas", "absurd", "preposterous", "ludicrous", "outrageous", "unbelievable", 
    "unthinkable", "unimaginable", "inconceivable", "impossible", "hopeless", 
    "lost", "doomed", "damned", "cursed", "hexed", "jinxed", "unlucky", 
    "unfortunate", "ill-fated", "star-crossed", "tragic", "sad", "miserable", 
    "wretched", "pitiful", "pathetic", "sorry", "lamentable", "regrettable", 
    "unfortunate", "unhappy", "sorrowful", "grieving", "mournful", "heartbroken", 
    "devastated", "crushed", "destroyed", "ruined", "shattered", "broken", 
    "defeated", "beaten", "overwhelmed", "powerless", "helpless", "hopeless", 
    "desperate", "despairing", "anguished", "tormented", "tortured", "suffering", 
    "agonized", "miserable", "wretched", "unhappy", "sad", "depressed", 
    "despondent", "melancholic", "gloomy", "dreary", "dismal", "bleak", 
    "dark", "shadowy", "sinister", "malevolent", "malicious", "wicked", 
    "evil", "sinful", "corrupt", "depraved", "degenerate", "perverse", 
    "twisted", "disturbed", "unhinged", "deranged", "psychotic", "maniacal", 
    "insane", "crazy", "lunatic", "mad", "bonkers", "disappointed", "JR"
    ));

    private static ArrayList<String> goodWords = new ArrayList<> (Arrays.asList(
        "good", "excellent", "amazing", "wonderful", "fantastic", "outstanding",
        "great", "positive", "impressive", "superb", "brilliant", "incredible", 
        "awesome", "remarkable", "marvelous", "successful", "inspirational",
        "motivating", "exceptional", "extraordinary", "phenomenal", "outstanding",
        "uplifting", "productive", "energetic", "joyful", "cheerful", "delightful",
        "thrilling", "splendid", "magnificent", "stellar", "glorious", "radiant",
        "vibrant", "lively", "optimistic", "hopeful", "encouraging", "rewarding",
        "fulfilling", "satisfying", "heartwarming", "charming", "captivating",
        "enchanting", "mesmerizing", "breathtaking", "stunning", "electrifying",
        "invigorating", "refreshing", "rejuvenating", "reassuring", "comforting",
        "peaceful", "serene", "tranquil", "harmonious", "balanced", "wholesome",
        "nurturing", "supportive", "compassionate", "kind", "generous", "gracious",
        "humble", "grateful", "thankful", "blessed", "fortunate", "lucky", "prosperous",
        "flourishing", "thriving", "blossoming", "blooming", "radiant", "shining",
        "glowing", "sparkling", "dazzling", "gleaming", "twinkling", "luminous",
        "vivid", "colorful", "dynamic", "vital", "robust", "resilient", "strong",
        "powerful", "mighty", "unstoppable", "unstoppable", "unbeatable", "triumphant",
        "victorious", "winning", "champion", "heroic", "legendary", "mythic", "epic",
        "grand", "majestic", "regal", "royal", "noble", "dignified", "elegant",
        "graceful", "polished", "refined", "sophisticated", "classy", "stylish",
        "trendy", "fashionable", "chic", "modern", "innovative", "creative", "artistic",
        "imaginative", "visionary", "inventive", "resourceful", "clever", "smart",
        "intelligent", "wise", "knowledgeable", "insightful", "perceptive", "astute",
        "shrewd", "sharp", "quick-witted", "brilliant", "genius", "prodigy", "masterful",
        "skilled", "talented", "gifted", "accomplished", "proficient", "expert",
        "adept", "competent", "capable", "efficient", "effective", "productive",
        "diligent", "hardworking", "dedicated", "committed", "passionate", "enthusiastic",
        "zealous", "fervent", "ardent", "devoted", "loyal", "faithful", "trustworthy",
        "reliable", "dependable", "consistent", "steady", "stable", "secure", "safe",
        "protected", "guarded", "shielded", "fortified", "resilient", "enduring",
        "lasting", "permanent", "eternal", "timeless", "classic", "iconic", "legendary",
        "unforgettable", "memorable", "notable", "significant", "meaningful", "profound",
        "deep", "thoughtful", "reflective", "contemplative", "meditative", "calm",
        "relaxed", "soothing", "healing", "restorative", "renewing", "revitalizing",
        "empowering", "liberating", "freeing", "enlightening", "illuminating", "revealing",
        "discovering", "exploring", "adventurous", "bold", "courageous", "brave",
        "fearless", "daring", "audacious", "confident", "self-assured", "assertive",
        "decisive", "determined", "resolute", "focused", "disciplined", "organized",
        "structured", "methodical", "systematic", "logical", "rational", "reasonable",
        "sensible", "practical", "realistic", "achievable", "attainable", "feasible",
        "possible", "doable", "manageable", "workable", "functional", "operational",
        "effective", "efficient", "productive", "fruitful", "beneficial", "advantageous",
        "valuable", "precious", "treasured", "cherished", "beloved", "adored", "loved",
        "admired", "respected", "esteemed", "honored", "praised", "celebrated", "applauded",
        "acclaimed", "recognized", "acknowledged", "appreciated", "valued", "esteemed",
        "honored", "respected", "revered", "venerated", "worshiped", "idolized", "adored"
    ));

    public static ArrayList<String> arrayer(String text) {
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");
        text = text.toLowerCase();
        ArrayList<String> textArray = new ArrayList<> (Arrays.asList(text.split(" ")));
        
        return textArray;   
    }

 

    public static ArrayList<String> findBadWords(ArrayList<String> list) {
        ArrayList<String> listOfBadWords = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            String wordCheck = list.get(i);
            for (int j = 0; j < badWords.size(); j++) {
                String badWord = badWords.get(j);
                if (wordCheck.equals(badWord)) {
                    listOfBadWords.add(badWord);
                }
            }
        }
        return listOfBadWords;
    }

    public static ArrayList<String> findGoodWords(ArrayList<String> list) {
        ArrayList<String> listOfGoodWords = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            String wordCheck = list.get(i);
            for (int j = 0; j < goodWords.size(); j++) {
                String goodWord = goodWords.get(j);
                if (wordCheck.equals(goodWord)) {
                    listOfGoodWords.add(goodWord);
                }
            }
        }
        return listOfGoodWords;
}

    public static void textCleaner(String text) {
        ArrayList<String> cleanedText = arrayer(text);

        for (int i = 0; i < cleanedText.size(); i++) {
            String arrayedText = cleanedText.get(i);
            for (int j = 0; j < wordsToRemove.size(); j++) {
                String wordChecked = wordsToRemove.get(j);

                if (arrayedText.equals(wordChecked)) {
                    cleanedText.remove(i);
                    i--;
                }
            }
        }

        //Analysis
        ArrayList<String> goodWordsList = findGoodWords(cleanedText);
        int amountOfGoodWords = goodWordsList.size();
        ArrayList<String> badWordsList = findBadWords(cleanedText);
        int amountOfBadWords = badWordsList.size();

        System.out.println(
            "Here is the cleaned version of the source: " + cleanedText + "\n" +
            "There are " + amountOfGoodWords + " positive words: " + goodWordsList + "\n" +
            "There are " + amountOfBadWords + " negative words: " + badWordsList
        );

    }

    public static void textCleaner(ArrayList<String> list) {
        int totalBadWords = 0;
        int totalGoodWords = 0;
        for (int k = 0; k < list.size(); k++) {
            ArrayList<String> cleanedText = arrayer(list.get(k));

            for (int i = 0; i < cleanedText.size(); i++) {
                String arrayedText = cleanedText.get(i);
                for (int j = 0; j < wordsToRemove.size(); j++) {
                    String wordChecked = wordsToRemove.get(j);

                    if (arrayedText.equals(wordChecked)) {
                        cleanedText.remove(i);
                        i--;
                    }
                }
            }

            //Analysis
            ArrayList<String> goodWordsList = findGoodWords(cleanedText);
            int amountOfGoodWords = goodWordsList.size();
            totalGoodWords += goodWordsList.size();
            ArrayList<String> badWordsList = findBadWords(cleanedText);
            int amountOfBadWords = badWordsList.size();
            totalBadWords += badWordsList.size();

            System.out.println(
                "Here is the cleaned version of the source number " + k + ": " + cleanedText + "\n" +
                "There are " + amountOfGoodWords + " positive words: " + goodWordsList + "\n" +
                "There are " + amountOfBadWords + " negative words: " + badWordsList + "\n"
            );

        }
        System.out.println(
                "\n Total Count Of All Bad Words: " + totalGoodWords +
                "\n Total Count Of All Bad Words: " + totalBadWords
            );
        
    }

    

}