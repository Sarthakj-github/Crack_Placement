class Solution
{
    int tour(int petrol[], int distance[])
    {
	    // Your code here	
	    int n=petrol.length;
	    for(int i=0;i<n;i++){
	        petrol[i]-=distance[i];
	    }
	    
	    int ans=0,s=0,p=0;
        for(int i=0;i<n;i++){
            s+=petrol[i];
            if(p<0){
                p=petrol[i];
                ans=i;
            }
            else{
                p+=petrol[i];
            }
        }
        if(s<0) return -1;
        return ans;
    }
}
