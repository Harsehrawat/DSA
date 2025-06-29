// write a method to sort an array of strings so that all the anagrams are next to each other .

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of string array:");
        int n = sc.nextInt();
        sc.nextLine(); // Clear the newline character

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter String No. " + (i + 1) + ":");
            input[i] = sc.nextLine();
        }

        List<List<String>> groupedAnagrams = groupAnagrams(input);

        // Print the grouped anagrams
        System.out.println("\nGrouped Anagrams:");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = sortChars(s);  // Sorted version as key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());  // Return grouped anagrams
    }

    static String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
