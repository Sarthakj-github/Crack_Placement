class Solution {
    public String reverseWords(String s) {
        int p=-1,n=s.length();
        String ans="";
        for (int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                if(p!=-1){
                    ans=s.substring(p,i)+ans;
                    p=-1;
                    ans=' '+ans;
                }
            }
            else if(p==-1)   p=i;
        }
        
        if(p!=-1){
            ans=s.substring(p,n)+ans;
        }
        if(ans.charAt(0)==' ')
            ans=ans.substring(1,ans.length());
        return ans;
    }
}
