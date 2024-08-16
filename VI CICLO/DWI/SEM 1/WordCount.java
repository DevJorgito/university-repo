import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    private Map<String, Integer> wordCountMap;
    private int totalWords;

    public WordCount() {
        wordCountMap = new HashMap<>();
        totalWords = 0;
    }

    public void countWords(List<String> words) {
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            totalWords++;
        }
    }

    public Map<String, Integer> getWordCountMap() {
        return wordCountMap;
    }

    public int getTotalWords() {
        return totalWords;
    }
}
