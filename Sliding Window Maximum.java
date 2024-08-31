class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> H = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length, i = 0, ans[] = new int[n - k + 1];

        while (i < n) {
            H.add(new int[]{nums[i], i});
            while (!H.isEmpty() && H.peek()[1] <= i - k)
                H.poll();
            if (i >= k - 1) ans[i - k + 1] = H.peek()[0];
            i++;
        }

        return ans;
    }
}
