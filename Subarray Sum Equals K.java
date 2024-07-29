class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> d = new HashMap<>();
        d.put(0,1);
        int c=0,s=0;
        for(int num:nums){
            s+=num;
            if(d.containsKey(s-k))  c+=d.get(s-k);
            d.put(s,d.getOrDefault(s,0)+1);
        }
        return c;
    }
}
