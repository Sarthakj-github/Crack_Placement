class TrieNode {
    TrieNode[] d;
    boolean end;

    TrieNode() {
        d = new TrieNode[26];
        end = false; // Correctly initialize `end` here
    }
}

class Solution {
    public static int wordBreak(String A, ArrayList<String> B) {
        TrieNode root = new TrieNode();
        for (String b : B) {
            TrieNode temp = root;
            for (char c : b.toCharArray()) {
                int p = c - 'a';
                if (temp.d[p] == null) {
                    temp.d[p] = new TrieNode();
                }
                temp = temp.d[p];
            }
            temp.end = true;
        }
        return break_find(0, A, root);
    }

    static int break_find(int i, String s, TrieNode t) {
        if (i == s.length()) return 1;
        TrieNode temp = t;
        for (int j = i; j < s.length(); j++) {
            int c = s.charAt(j) - 'a';
            if (temp.d[c] == null) return 0;
            temp = temp.d[c];
            if (temp.end) {
                if (break_find(j + 1, s, t) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
