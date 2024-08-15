import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        Map<Character, Integer> d = new HashMap<>();

        for (int i = 0; i < n; i++) {
            d.put(s.charAt(i), d.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair<Integer, Character>> H = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for (char c : d.keySet()) {
            H.add(new Pair<>(d.get(c), c));
        }

        char prev = '\0';
        int prevCount = 0;

        StringBuilder ans = new StringBuilder();
        
        while (!H.isEmpty()) {
            Pair<Integer, Character> p = H.poll();
            char currChar = p.getValue();
            int currCount = p.getKey();
            
            if (prevCount > 0) {
                H.add(new Pair<>(prevCount, prev));
            }
            
            ans.append(currChar);
            prev = currChar;
            prevCount = currCount - 1;
        }
        
        return ans.length() == n ? ans.toString() : "";
    }
}
