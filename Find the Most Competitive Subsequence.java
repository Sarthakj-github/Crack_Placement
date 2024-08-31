class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int d = nums.length - k;

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peekLast() > num && d-- > 0) 
                stack.pollLast();
            stack.addLast(num);
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) 
            res[i] = stack.pollFirst();
        return res;
    }
}
