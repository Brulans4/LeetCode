package _127_WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        int res = ladderLength("hit", "cog", list);
        if (res != 5) {
            System.out.println("Wrong answer, got: " + res + " (expected 5)");
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> unVisited = new HashSet<>(wordList);

        List<String> bfs = new ArrayList<>();
        List<Integer> dists = new ArrayList<>();

        bfs.add(beginWord);
        dists.add(1);

        while (!bfs.isEmpty()) {
            String currentWord = bfs.removeFirst();
            int currentDist = dists.removeFirst();

            if (Objects.equals(currentWord, endWord)) {
                return currentDist;
            }

            unVisited.remove(currentWord);

            for (int i = 0; i < currentWord.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    String nextWordCandidate = replaceCharAt(currentWord, i, (char) ('a' + j));

                    if (unVisited.contains(nextWordCandidate)){
                        bfs.add(nextWordCandidate);
                        dists.add(currentDist + 1);
                    }
                }
            }
        }
        return 0;
    }

    public static String replaceCharAt(String str, int index, char newChar) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, newChar);
        return sb.toString();
    }

    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();

        List<String> bfs = new ArrayList<>();
        List<Integer> dists = new ArrayList<>();

        bfs.add(beginWord);
        dists.add(1);

        while (!bfs.isEmpty()) {
            String currentWord = bfs.removeFirst();
            int currentDist = dists.removeFirst();

            visited.add(currentWord);

            if (Objects.equals(currentWord, endWord)) {
                return currentDist;
            }

            for (String nextWord : wordList) {

                if (!visited.contains(nextWord)) {
                    if (differOneChar(currentWord, nextWord)) {
                        bfs.add(nextWord);
                        dists.add(currentDist + 1);
                    }
                }
            }
        }
        return 0;
    }

    public static boolean differOneChar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int differences = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
                if (differences > 1) {
                    return false;
                }
            }
        }
        return differences == 1;
    }
}
