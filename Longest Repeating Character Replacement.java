class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> d = new HashMap<>();
        int n = s.length(), i = 0, maxCount = 0, maxLength = 0;

        for (int j = 0; j < n; j++) {
            char p = s.charAt(j);
            d.put(p, d.getOrDefault(p, 0) + 1);
            maxCount = Math.max(maxCount, d.get(p));

            // If the current window size minus the count of the most frequent character is greater than k, shrink the window
            if (j - i + 1 - maxCount > k) {
                char q = s.charAt(i);
                d.put(q, d.get(q) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
