class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        nums[0]%=k;
        for(int i=1;i<nums.length;i++){
            nums[i] = (nums[i]+nums[i-1])%k;
        }

        Map<Integer,Integer> d = new HashMap<>();
        int ans=0,p;
        for(int i : nums){
            if(i==0)  d.put(i,d.getOrDefault(i,0)+1);
            else{
                if(i>0) p = i-k;
                else    p = k+i;
                if(d.containsKey(p))    ans+=d.get(p);
            }
            if(d.containsKey(i)) ans+=d.get(i);
            if(i!=0)    d.put(i,d.getOrDefault(i,0)+1);
        }
        return ans;
    }
}
