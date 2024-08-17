class Solution {
    int[] prefix;
    public int strStr(String haystack, String needle) {
        int m=haystack.length(),n=needle.length();
        prefix = new int[n];
        cal_pre(needle,n);
        int i=0,j=0;
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j))  j++;
            else if(j>0){
                j=prefix[j-1];
                i--;
            }
            i++;
            if(j==n)    return i-n;
        }
        return -1;

    }

    void cal_pre(String s,int n){
        for(int i=1;i<n;i++){
            int j=prefix[i-1];
            while(j>0 && s.charAt(i)!=s.charAt(j))  j=prefix[j-1];
            if(s.charAt(i)==s.charAt(j))    j++;
            prefix[i]=j;
        }
    }
}
