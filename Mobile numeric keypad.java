class Solution {
    public long getCount(int n) {
        // Your code goes here
        long[] t_seqs = new long[10];
        Arrays.fill(t_seqs,1);
        long mod = Long.MAX_VALUE;
        
        while(--n>0){
            long[] n_seqs = new long[10];
            
            n_seqs[0] = (t_seqs[0]+t_seqs[8])%mod;
            n_seqs[1] = (t_seqs[1]+t_seqs[2]+t_seqs[4])%mod;
            n_seqs[2] = (t_seqs[2]+t_seqs[1]+t_seqs[3]+t_seqs[5])%mod;
            n_seqs[3] = (t_seqs[3]+t_seqs[2]+t_seqs[6])%mod;
            n_seqs[4] = (t_seqs[4]+t_seqs[1]+t_seqs[5]+t_seqs[7])%mod;
            n_seqs[5] = (t_seqs[5]+t_seqs[2]+t_seqs[4]+t_seqs[6]+t_seqs[8])%mod;
            n_seqs[6] = (t_seqs[6]+t_seqs[3]+t_seqs[5]+t_seqs[9])%mod;
            n_seqs[7] = (t_seqs[7]+t_seqs[4]+t_seqs[8])%mod;
            n_seqs[8] = (t_seqs[8]+t_seqs[5]+t_seqs[7]+t_seqs[0]+t_seqs[9])%mod;
            n_seqs[9] = (t_seqs[9]+t_seqs[6]+t_seqs[8])%mod;
            
            t_seqs = n_seqs;
        }
        
        
        long ans = 0;
        for(long seqs:t_seqs){
            ans=(ans+seqs)%mod;
        }
        return ans;
    }
}
