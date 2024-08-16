class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
        int n = grid.length;
        int[][] L = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)   Q.add(new Pair<>(i,j));
            }
        }

        int mx = 0;
        while (!Q.isEmpty()) {
            Pair<Integer, Integer> p = Q.poll();
            int x = p.getKey();
            int y = p.getValue();

            for(int[] l:L){
                int a=x+l[0];
                int b=y+l[1];
                if(0<=a && a<n && 0<=b && b<n && grid[a][b]==0){
                    grid[a][b]=grid[x][y]+1;
                    Q.add(new Pair<>(a,b));
                    if(grid[a][b]>mx)
                        mx=grid[a][b];
                }
            }

        }
        return mx-1;
    }
}
