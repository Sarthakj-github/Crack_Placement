class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> d = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            d.put(t.charAt(i), d.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = d.size();
        int i = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int formed = 0;
        int ansLen = s.length() + 1;
        String result = "";

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (d.containsKey(c)) {
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

                if (windowCounts.get(c).intValue() == d.get(c).intValue()) {
                    formed++;
                }
            }

            while (formed == required) {
                if (j - i + 1 < ansLen) {
                    ansLen = j - i + 1;
                    result = s.substring(i, j + 1);
                }

                char leftChar = s.charAt(i);
                if (d.containsKey(leftChar)) {
                    windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                    if (windowCounts.get(leftChar).intValue() < d.get(leftChar).intValue()) {
                        formed--;
                    }
                }

                i++;
            }
        }

        return ansLen == s.length() + 1 ? "" : result;
    }
}
