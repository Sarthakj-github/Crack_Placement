class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1, a = 0, b = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (a > 0 || s.charAt(i) == '#')) a += s.charAt(i--) == '#' ? 1 : -1;
            while (j >= 0 && (b > 0 || t.charAt(j) == '#')) b += t.charAt(j--) == '#' ? 1 : -1;
            
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false; // One string is exhausted before the other
            i--; j--;
        }
        return true;
    }
}
