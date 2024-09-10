class Solution {
    public int nthUglyNumber(int n) {

        int[] uglys = new int[n];
        uglys[0]=1;
        
        int i2=0,i3=0,i5=0;
        int n2=2,n3=3,n5=5;

        for(int i=1;i<n;i++){
            int nugly = Math.min(n2,Math.min(n3,n5));
            uglys[i]=nugly;

            if(n2==nugly)
                n2=2*uglys[++i2];
            if(n3==nugly)
                n3=3*uglys[++i3];
            if(n5==nugly)
                n5=5*uglys[++i5];
        }

        return uglys[n-1];
    }
}
