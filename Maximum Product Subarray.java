class Solution {
    public int maxProduct(int[] nums) {
        long pmin = 1, pmax = 1;
        long res = Long.MIN_VALUE;
        for (int num : nums) {
            long a = pmin * num;
            long b = pmax * num;
            pmax = Math.max(Math.max(a, b), num);
            pmin = Math.min(Math.min(a, b), num);
            res = Math.max(res,pmax);
        }
        return (int)res;
    }
}
