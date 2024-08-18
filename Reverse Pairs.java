class Solution {
    int ans;
    int[] arr;

    public int reversePairs(int[] nums) {
        ans = 0;
        arr = nums;
        mergeSort(0, nums.length - 1);
        return ans;
    }

    void mergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    void merge(int l, int m, int r) {
        // Count reverse pairs
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && arr[i] > 2L * arr[j]) {
                j++;
            }
            ans += (j - (m + 1));
        }

        // Merge two sorted halves
        ArrayList<Integer> temp = new ArrayList<>();
        int f = l, s = m + 1;
        while (f <= m && s <= r) {
            if (arr[f] <= arr[s]) {
                temp.add(arr[f++]);
            } else {
                temp.add(arr[s++]);
            }
        }
        while (f <= m) temp.add(arr[f++]);
        while (s <= r) temp.add(arr[s++]);

        // Copy sorted elements back to the original array
        for (int i = 0; i < temp.size(); i++) {
            arr[l + i] = temp.get(i);
        }
    }
}
