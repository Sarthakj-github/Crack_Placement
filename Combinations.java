class Solution {
    int K, N;
    List<List<Integer>> L;
    List<Integer> l;
    
    public List<List<Integer>> combine(int n, int k) {
        L = new ArrayList<>();
        K = k;
        N = n + 1;
        l = new ArrayList<>();
        trav(1);
        return L;
    }

    void trav(int i) {
        if (l.size() == K) {
            L.add(new ArrayList<>(l));
            return;
        }
        if (i == N) return;

        // Exclude the current element
        trav(i + 1);
        
        // Include the current element
        l.add(i);
        trav(i + 1);
        l.remove(l.size() - 1);
    }
}
