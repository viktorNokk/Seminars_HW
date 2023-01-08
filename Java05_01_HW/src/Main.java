/*
Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words1 = {"leetcode","is","amazing","as","is"};
        String[] words2 = {"amazing","leetcode","is"};

        // Создадим hashmaps для хранения частоты каждого word
        Map<String, Integer> wordCount1 = new HashMap<>();
        Map<String, Integer> wordCount2 = new HashMap<>();

        // Заполняем hashmaps
        for (String word : words1) {
            int count = wordCount1.getOrDefault(word, 0);
            wordCount1.put(word, count + 1);
        }
        for (String word : words2) {
            int count = wordCount2.getOrDefault(word, 0);
            wordCount2.put(word, count + 1);
        }

        // Переберем одну hashmap и проверим word котрые встречаются один раз в обеих
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordCount1.entrySet()) {
            String word = entry.getKey();
            int frequency1 = entry.getValue();
            int frequency2 = wordCount2.getOrDefault(word, 0);
            if (frequency1 == 1 && frequency2 == 1) {
                count++;
            }
        }

        System.out.println("Количество слов, которые встречаются один раз в обоих массивах: " + count);
    }
}