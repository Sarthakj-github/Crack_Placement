class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int[][] L = {{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
        int a,b,c;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c=board[i][j];
                for(int[] l:L){
                    a=l[0]+i;
                    b=l[1]+j;
                    if(0<=a && a<m && 0<=b && b<n && board[a][b]>0) c++;
                }
                if(board[i][j]==0)  c=-c;
                board[i][j]=c;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]<=0){
                    if(board[i][j]==-3) board[i][j]=1;
                    else    board[i][j]=0;
                }
                else if(board[i][j]==3 || board[i][j]==4){
                    board[i][j]=1;
                }
                else{
                    board[i][j]=0;
                }
            }
        }
    }
}
