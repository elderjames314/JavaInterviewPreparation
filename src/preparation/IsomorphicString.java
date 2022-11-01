package preparation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class IsomorphicString {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(areTheyIsomorphic2(s, t));
        System.out.println(areTheyIsomorphic(s, t));
    }
    private static boolean areTheyIsomorphic2(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i), v = t.charAt(i);
            if(mapST.containsKey(k) && !mapST.get(k).equals(v) || (mapTS.containsKey(v) && !mapTS.get(v).equals(k))) return false;
            mapST.put(k, v);
            mapTS.put(v, k);
        }
        return true;
     }
    private static boolean areTheyIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 1 && t.length()==1) return true;
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i), v = t.charAt(i);
            if(map.containsKey(k)) {
                if(v != map.get(k)) return false;
            }else {
                if(visited.contains(v)) return false;
                map.put(k, v);
                visited.add(v);
            }
        }
        return true;
    }
}
