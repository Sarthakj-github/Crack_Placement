class Solution {
    int n;
    int[] prices;
    HashMap<Pair<Integer, Integer>, Integer> d;

    public int maxProfit(int[] p) {
        n = p.length;
        prices = p;
        d = new HashMap<>();
        return trav(1, prices[0]);
    }

    int trav(int i, int p) {
        if (i == n) {
            return 0;
        }

        Pair<Integer, Integer> currentPair = new Pair<>(i, p);

        if (!d.containsKey(currentPair)){
            if (prices[i] < p) {
                d.put(currentPair, trav(i + 1, prices[i]));
            }
            else {
                d.put(currentPair, Math.max(prices[i] - p + trav(i + 1, prices[i]), trav(i + 1, p)));
            }
        }

        return d.get(currentPair);
    }
}
