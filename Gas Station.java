class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int s=0,ind=0,p=0;
        for(int i=0;i<n;i++){
            s+=gas[i]-cost[i];
            p+=gas[i]-cost[i];
            if(s<0){
                ind=i+1;    s=0;
            }
        }
        if(p<0) return -1;
        return ind;
    }
}
