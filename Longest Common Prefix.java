class Solution {
    public String longestCommonPrefix(String[] strs) {

        int l = strs[0].length();
        for (String str : strs) {
            l = Math.min(l, str.length());
            for (int j = 0; j < l; j++) {
                if (str.charAt(j) != strs[0].charAt(j)) {
                    l = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, l);
    }
}
