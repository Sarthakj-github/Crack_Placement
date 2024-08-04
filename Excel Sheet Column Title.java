class Solution {
    public String convertToTitle(int columnNumber) {
        int m=26,p;
        String ans = "";
        while(columnNumber>0){
            columnNumber--;
            p=columnNumber%m;
            ans = (char)(p+'A') + ans;
            columnNumber/=m;
        }
        return ans;
    }
}
