class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        int n=s.length();
        boolean[][] palsub = new boolean[n][n];

        for(int k=0;k<n;k++){
            int i=0,j=k;
            while(j<n){
                if(k==0)    palsub[i][j]=true;
                else if(k==1)    palsub[i][j]=s.charAt(i)==s.charAt(j);
                else    palsub[i][j]=s.charAt(i)==s.charAt(j) && palsub[i+1][j-1];
                i++;j++;
            }
        }

        trav(0,n,s,new ArrayList(),palsub,ans);
        return ans;
    }

    void trav(int i,int n,String s,ArrayList<String> S,boolean[][] palsub,List<List<String>> ans){
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
