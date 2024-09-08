class Solution {
    static String res;
    
    public static String findMaximumNum(String s, int k) {
        res = s;
        dfs(s.toCharArray(), k, 0);
        return res;
    }

    public static void dfs(char[] s, int k, int idx) {
        if (k == 0 || idx == s.length) {
            String cur = new String(s);
            if (cur.compareTo(res) > 0) {
                res = cur;
            }
            return;
        }

        char maxChar = s[idx];
        for (int i = idx + 1; i < s.length; i++) {
            if (s[i] > maxChar) {
                maxChar = s[i];
            }
        }

        if (maxChar != s[idx]) {
            k--;
        }

        for (int i = idx; i < s.length; i++) {
            if (s[i] == maxChar) {
                swap(s, idx, i);
                dfs(s, k, idx + 1);
                swap(s, idx, i);  // backtrack
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
