class Solution {
    public int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        TreeSet<Integer> availableSlots = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            availableSlots.add(i);
        }

        int[] res = {0, 0};

        for (Job j : arr) {
            Integer slot = availableSlots.floor(j.deadline);
            if (slot != null) {
                availableSlots.remove(slot);
                res[0]++;
                res[1] += j.profit;
            }
        }

        return res;
    }
}
