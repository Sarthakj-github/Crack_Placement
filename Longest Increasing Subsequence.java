class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> L = new ArrayList<>();
        
        for (int n : nums) {
            int i = 0, j = L.size() - 1, insertPos = 0;
            while (i <= j) {
                int m = (i + j) / 2;
                if (L.get(m) < n) {
                    insertPos = m + 1;
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            if (insertPos == L.size()) {
                L.add(n);
            } else {
                L.set(insertPos, n);
            }
        }
        return L.size();
    }
}
