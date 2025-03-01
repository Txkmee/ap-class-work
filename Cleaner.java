import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Cleaner {
    private static ArrayList<String> badWords = loadFile("badWords.txt");
    private static ArrayList<String> goodWords = loadFile("goodWords.txt");
    private static ArrayList<String> wordsToRemove = loadFile("wordsToRemove.txt");

   private static ArrayList<String> loadFile(String filename) {
    ArrayList<String> list = new ArrayList<>();
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim().toLowerCase();
            if (word.isEmpty() == false) {
                list.add(word);
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("dum dumb there are no file by the name" + filename);
    }
    return list;
}

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
        int totalWords = 0;
    
        for (int k = 0; k < list.size(); k++) {
            ArrayList<String> cleanedText = arrayer(list.get(k));
    
            for (int i = cleanedText.size() - 1; i >= 0; i--) {
                String arrayedText = cleanedText.get(i);
                for (int j = 0; j < wordsToRemove.size(); j++) {
                    String wordChecked = wordsToRemove.get(j);
    
                    if (arrayedText.equals(wordChecked)) {
                        cleanedText.remove(i); 
                        break; 
                    }
                }
            }
    
            totalWords += cleanedText.size();
            ArrayList<String> goodWordsList = findGoodWords(cleanedText);
            int amountOfGoodWords = goodWordsList.size();
            totalGoodWords += amountOfGoodWords;
    
            ArrayList<String> badWordsList = findBadWords(cleanedText);
            int amountOfBadWords = badWordsList.size();
            totalBadWords += amountOfBadWords;
    
            double goodWordsPercentage = (double) amountOfGoodWords / cleanedText.size() * 100;
            double badWordsPercentage = (double) amountOfBadWords / cleanedText.size() * 100;
    
            System.out.println(
                "Here is the cleaned version of the source number " + k + ": " + cleanedText + "\n" +
                "\nThere are " + amountOfGoodWords + " positive words: " + goodWordsList + "\n" +
                "There are " + amountOfBadWords + " negative words: " + badWordsList + "\n" +
                "Positive Words Percentage: " + String.format("%.2f", goodWordsPercentage) + "%\n" +
                "Negative Words Percentage: " + String.format("%.2f", badWordsPercentage) + "%\n"
            );
        }
    
        double overallGoodWordsPercentage = (double) totalGoodWords / totalWords * 100;
        double overallBadWordsPercentage = (double) totalBadWords / totalWords * 100;
    
        System.out.println(
            "\nTotal Count Of All Good Words: " + totalGoodWords +
            "\nTotal Count Of All Bad Words: " + totalBadWords +
            "\nOverall Positive Words Percentage: " + String.format("%.2f", overallGoodWordsPercentage) + "%" +
            "\nOverall Negative Words Percentage: " + String.format("%.2f", overallBadWordsPercentage) + "%"
        );
    }

    

}