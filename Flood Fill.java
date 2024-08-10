class Solution {
    int[][] vis,img;
    int clr,m,n;
    int[][] L = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length; n=image[0].length;
        vis = new int[m][n];
        img = image;    clr = color;
        flood(sr,sc);   return img;
    }

    void flood(int i,int j){
        vis[i][j]=1;
        int p,q;
        for(int[] a : L){
            p=i+a[0];   q=j+a[1];
            if(0<=p && p<m && 0<=q && q<n && vis[p][q]==0 && img[i][j]==img[p][q])  flood(p,q);
        }
        img[i][j]=clr;
    }
}
