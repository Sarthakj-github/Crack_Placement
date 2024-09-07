class Solution {
    public int knightDialer(int n) {
        long[] ph_nums = new long[10], new_nums;
        long mod = 1000000007;  // To avoid overflow
        Arrays.fill(ph_nums, 1);  // Every digit is reachable at the start

        while (--n > 0) {
            new_nums = new long[10];
            new_nums[0] = (ph_nums[4] + ph_nums[6])%mod;
            new_nums[1] = (ph_nums[6] + ph_nums[8])%mod;
            new_nums[2] = (ph_nums[7] + ph_nums[9])%mod;
            new_nums[3] = (ph_nums[4] + ph_nums[8])%mod;
            new_nums[4] = (ph_nums[0] + ph_nums[3] + ph_nums[9])%mod;
            new_nums[6] = (ph_nums[0] + ph_nums[1] + ph_nums[7])%mod;
            new_nums[7] = (ph_nums[2] + ph_nums[6])%mod;
            new_nums[8] = (ph_nums[1] + ph_nums[3])%mod;
            new_nums[9] = (ph_nums[2] + ph_nums[4])%mod;
            ph_nums = new_nums;
        }

        long sum = 0;
        for (long num : ph_nums) {
            sum = (sum + num) % mod;
        }

        return (int)sum;
    }
}
