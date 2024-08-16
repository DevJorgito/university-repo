import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String filePath = "archivo.txt";

        FileReader fileReader = new FileReader(filePath);
        WordCount wordCount = new WordCount();

        try {
            List<String> words = fileReader.readWords();
            wordCount.countWords(words);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        Map<String, Integer> wordCountMap = wordCount.getWordCountMap();
        int totalWords = wordCount.getTotalWords();

        System.out.printf("%-20s %-10s %-10s\n", "Word", "Frequency", "Percentage");
        System.out.println("------------------------------------------------------");

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / totalWords * 100;
            System.out.printf("%-20s %-10d %-10.2f%%\n", word, count, percentage);
        }
    }
}
