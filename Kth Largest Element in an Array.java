class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums) h.add(i);
        while(k-->1)  h.poll();
        return h.peek();
    }
}
