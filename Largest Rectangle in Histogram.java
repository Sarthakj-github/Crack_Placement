class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length,c,j;
        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Integer> Sl = new Stack();
        Stack<Integer> Sr = new Stack();

        for(int i=0;i<n;i++){
            c=1;
            while(!Sl.isEmpty() && heights[Sl.peek()]>=heights[i])
                c+=l[Sl.pop()];
            Sl.push(i);
            l[i]=c;
            c=1;    j=n-i-1;
            while(!Sr.isEmpty() && heights[Sr.peek()]>=heights[j])
                c+=r[Sr.pop()];
            Sr.push(j);
            r[j]=c;
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(r[i]+l[i]-1)*heights[i]);
        }

        return ans;
    }
}
