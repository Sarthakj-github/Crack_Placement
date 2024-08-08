class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> h = new PriorityQueue<>();
        int i,n=nums.length;
        for(i=0;i<n;i++){
            if(i<k) h.add(nums[i]);
            else if(h.peek()<nums[i]){
                h.poll();
                h.add(nums[i]);
            }
        }
        return h.peek();
    }
}
