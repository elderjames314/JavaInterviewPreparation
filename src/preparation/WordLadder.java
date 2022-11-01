package preparation;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String start =  "hit";
        String end = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> dict = new ArrayList<>(Arrays.asList(words));
        System.out.println(findTheShortestPath(start, end, dict));
        System.out.println(findShortCut(start, end, dict));
    }

    private static int findShortCut(String startWord, String endWord, List<String> wordsDics) {
        Set<String> wordDic = new HashSet<>(wordsDics);
        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);
        Set<String> visited = new HashSet<>();
        visited.add(startWord);
        int changes = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return changes;
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k < 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;
                        String newWord = new String(arr);
                        if(wordDic.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }

            }
            ++changes;
        }
        return 0;
    }

    private static int findTheShortestPath(String start, String end, List<String> dict) {
        Set<String> wordDic = new HashSet<>(dict);
        if(!wordDic.contains(end)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int changes = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(end)) return changes;
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k < 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;
                        String newWord = new String(arr);
                        if(wordDic.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }
}
