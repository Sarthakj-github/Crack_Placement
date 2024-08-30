class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] par = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(par[i], -1);
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && par[i][j] == -1)
                    ans = Math.max(ans, -trav(i, j, par, grid));
            }
        }

        int[][] L = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Map<Integer, Integer> S = new HashMap<>();
                    for (int[] l : L) {
                        int a = i + l[0], b = j + l[1];
                        if (0 <= a && a < n && 0 <= b && b < n && grid[a][b] == 1) {
                            int p = par[a][b];
                            if (p < 0) {
                                S.put(a * n + b, -p);
                            } else {
                                S.put(p, -par[p / n][p % n]);
                            }
                        }
                    }

                    int sum=0;
                    for (int s : S.keySet()) {
                        sum+=S.get(s);
                    }
                    ans = Math.max(ans, sum+1);
                }
            }
        }
        return ans;
    }

    int trav(int i, int j, int[][] par, int[][] grid) {
        int n = grid.length;
        int[][] L = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int p = i * n + j;

        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{i, j});
        par[i][j] = 0;

        while (!Q.isEmpty()) {
            int[] q = Q.poll();
            par[i][j]++;
            for (int[] l : L) {
                int a = q[0] + l[0], b = q[1] + l[1];
                if (0 <= a && a < n && 0 <= b && b < n && grid[a][b] == 1 && par[a][b] == -1) {
                    Q.add(new int[]{a, b});
                    par[a][b] = p;
                }
            }
        }
        par[i][j] = -par[i][j];
        return par[i][j];
    }
}
