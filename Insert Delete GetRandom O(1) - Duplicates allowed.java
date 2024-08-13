class RandomizedCollection {
    List<Integer> arr;
    Map<Integer, Set<Integer>> d;
    Random rand;

    public RandomizedCollection() {
        d = new HashMap<>();
        arr = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean ans = !d.containsKey(val);
        if (!d.containsKey(val)) {
            d.put(val, new HashSet<>());
        }
        d.get(val).add(arr.size());
        arr.add(val);
        return ans;
    }

    public boolean remove(int val) {
        if (!d.containsKey(val)) return false;
        int i = d.get(val).iterator().next();
        d.get(val).remove(i);
        if (i < arr.size() - 1) {
            int l = arr.get(arr.size() - 1);
            arr.set(i, l);  
            d.get(l).remove(arr.size() - 1);
            d.get(l).add(i);
        }
        arr.remove(arr.size() - 1);
        if (d.get(val).isEmpty()) {
            d.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}
