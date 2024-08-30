class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList();
        int n=S.length();
        boolean[][] palsub = new boolean[n][n];

        for(int k=0;k<n;k++){
            int i=0,j=k;
            while(j<n){
                if(k==0)    palsub[i][j]=true;
                else if(k==1)    palsub[i][j]=S.charAt(i)==S.charAt(j);
                else    palsub[i][j]=S.charAt(i)==S.charAt(j) && palsub[i+1][j-1];
                i++;j++;
            }
        }

        trav(0,n,S,new ArrayList(),palsub,ans);
        return ans;
    }

    static void trav(int i,int n,String s,ArrayList<String> S,boolean[][] palsub,ArrayList<ArrayList<String>> ans){
        if(i==n)    ans.add(new ArrayList<>(S));
        for(int j=i;j<n;j++){
            if(palsub[i][j]){
                S.add(s.substring(i,j+1));
                trav(j+1,n,s,S,palsub,ans);
                S.remove(S.size()-1);
            }
        }
    }
}
