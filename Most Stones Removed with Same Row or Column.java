class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] s : stones) {
            uf.union(s[0], s[1] + 10001); // Offset columns to differentiate them from rows
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] s : stones) {
            uniqueRoots.add(uf.find(s[0]));
        }

        return stones.length - uniqueRoots.size();
    }

    class UnionFind {
        Map<Integer, Integer> parent;

        UnionFind() {
            parent = new HashMap<>();
        }

        int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent.put(rootX, rootY);
            }
        }
    }
}
