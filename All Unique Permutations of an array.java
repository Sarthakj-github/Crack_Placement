class Solution {
    ArrayList<ArrayList<Integer>> ans;
    ArrayList<Integer> permu;
    int[] vis;
    int l;
    ArrayList<Integer> arr; 

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Solution solution = new Solution();
        solution.arr = arr; 
        Collections.sort(solution.arr);
        solution.ans = new ArrayList<>();
        solution.permu = new ArrayList<>();
        solution.vis = new int[n];
        solution.l = n;
        solution.perm(0);
        return solution.ans;
    }

    void perm(int i) {
        int prev = -1;
        if (i == l) {
            ans.add(new ArrayList<>(permu));
            return;
        }
        for (int j = 0; j < l; j++) {
            if (vis[j] == 0 && (prev == -1 || arr.get(j) != arr.get(prev))) {
                vis[j] = 1;
                permu.add(arr.get(j));
                perm(i + 1);
                permu.remove(permu.size() - 1);
                vis[j] = 0;
                prev = j;
            }
        }
    }
};
