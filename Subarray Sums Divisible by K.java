import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> d = new HashMap<>();
        int ans = 0, prefixSum = 0;

        d.put(0, 1); // Account for the case when the prefix sum itself is divisible by k

        for (int num : nums) {
            prefixSum = (prefixSum + num) % k;
            if (prefixSum < 0) prefixSum += k; // Handle negative remainders
            
            ans += d.getOrDefault(prefixSum, 0);
            d.put(prefixSum, d.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}
