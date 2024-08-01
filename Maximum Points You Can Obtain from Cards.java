class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int s=0;
        for(int i=0;i<k;i++){
            s+=cardPoints[i];
        }
        int m=s,j=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            s+=(cardPoints[j--]-cardPoints[i]);
            if(s>m){
                m=s;
            }
        }
        return m;
    }
}
