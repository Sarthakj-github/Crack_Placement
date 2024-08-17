class Solution {
    private int count = 0;
    private Set<Integer> vis = new HashSet<>();
    private List<Integer> ans = new ArrayList<>();
    
    public int countArrangement(int n) {
        n += 1;  // Adjust to match the original problem definition
        countArrangementHelper(1, n);
        return count;
    }

    private void countArrangementHelper(int i, int n) {
        if (i == n) {
            count++;
            return;
        }
        
        for (int j = 1; j < n; j++) {
            if (!vis.contains(j) && (i % j == 0 || j % i == 0)) {
                ans.add(j);
                vis.add(j);
                countArrangementHelper(i + 1, n);
                ans.remove(ans.size() - 1);
                vis.remove(j);
            }
        }
    }
}
