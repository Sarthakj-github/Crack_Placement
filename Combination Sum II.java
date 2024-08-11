class Solution {
    List<List<Integer>> ans;
    int[] space;
    int limit;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        space = candidates;
        limit = target;
        Arrays.sort(space);
        combine(0, 0, candidates.length, new ArrayList<Integer>());
        return ans;
    }

    void combine(int i, int s, int n, ArrayList<Integer> arr) {
        if (s == limit) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (i < n && (s + space[i]) <= limit) {
            arr.add(space[i]);
            combine(i + 1, s + space[i], n, arr);
            arr.remove(arr.size() - 1);
            while (i + 1 < n && space[i] == space[i + 1]) {
                i++;
            }
            combine(i + 1, s, n, arr);
        }
    }
}
