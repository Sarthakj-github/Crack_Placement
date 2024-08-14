class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length-1,n2=nums2.length-1;
        Map<Integer,Integer> d = new HashMap<>();
        Stack<Integer> S = new Stack();
        while(n2>=0){
            while(!S.isEmpty() && nums2[n2]>=S.peek()){
                S.pop();
            }
            if(S.isEmpty()) d.put(nums2[n2],-1);
            else    d.put(nums2[n2],S.peek());
            S.push(nums2[n2--]);
        }
        while(n1>=0){
            nums1[n1]=d.get(nums1[n1--]);
        }
        return nums1;
    }
}
