class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> H = new PriorityQueue<>();

        int i;
        for (i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                if (H.size() < ladders) {
                    H.add(diff);
                } else if (!H.isEmpty() && H.peek() < diff) {
                    bricks -= H.poll();
                    H.add(diff);
                } else {
                    bricks -= diff;
                }
                if (bricks < 0) break;
            }
        }
        return i;
    }
}
