// design an algorithm to find the freq of occurences of any given word in a book.
// what if we were running this algorithm multiple times? 

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String book = "The sun shines over the lake. The lake reflects the sun.";

        System.out.println("Book content:");
        System.out.println(book);

        // Step 1: Build frequency map from book
        Map<String, Integer> freqMap = freqMapper_Function(book);

        // Step 2: Ask for user input
        System.out.println("\nEnter words to find their frequency (type 'STOP' to finish):");

        Scanner sc = new Scanner(System.in);
        List<String> queryWords = new ArrayList<>();

        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("stop")) break;
            if (!input.isEmpty()) {
                queryWords.add(input);
            }
        }

        // Step 3: Output frequency of each query word
        for (String word : queryWords) {
            int freq = freqMap.getOrDefault(word, 0);
            System.out.println("The frequency of word \"" + word + "\" is: " + freq);
        }

        sc.close();
    }

    static Map<String, Integer> freqMapper_Function(String book) {
        Map<String, Integer> map = new HashMap<>();

        // Normalize text: lowercase + remove punctuation
        String[] words = book.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

        for (String word : words) {
            // Clean and update map
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
}
