class Solution {
    public static String smallestWindow(String s, String p) {
        Map<Character, Integer> d = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            d.put(p.charAt(i), d.getOrDefault(p.charAt(i), 0) + 1);
        }

        int k = d.size(); 
        int i = 0;
        Map<Character, Integer> d1 = new HashMap<>();
        int ans = s.length()+1; 
        String st = ""; 

        for (int j = 0; j < s.length(); j++) {
            char t = s.charAt(j);
            if (d.containsKey(t)) d1.put(t, d1.getOrDefault(t, 0) + 1);
            if (d.containsKey(t) && d.get(t).intValue() == d1.get(t).intValue()) k--;

            if (k == 0) {
                while (true) {
                    char l = s.charAt(i);
                    if (d.containsKey(l)) {
                        if (d1.get(l) > d.get(l)) {
                            d1.put(l, d1.get(l) - 1);
                            i++;
                        } else break;
                    } else {
                        i++;
                    }
                }

                if ((j - i + 1) < ans) {
                    ans = j - i + 1;
                    st = s.substring(i, j + 1); // Corrected substring extraction
                }
            }
        }

        return ans == s.length()+1 ? "-1" : st; // Corrected return statement
    }
}
