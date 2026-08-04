class Solution {
    int [][]dp;
    int fun(int[]a,int i ,int n ,int free){
        if(i>=n)
        return 0;

        if(dp[i][free]!=-1){
            return dp[i][free];
        }
        
        if(free==0)
        return dp[i][free]=fun(a,i+1,n,1);

        int c1=a[i]+fun(a,i+1,n,0);
        int c2=fun(a,i+1,n,1);

        return dp[i][free]=Math.max(c1,c2);


    }
    public int rob(int[] nums) {
        int n =nums.length;
        dp=new int [n][2];
        for(int []row :dp){
            Arrays.fill(row,-1);
        }
        return fun(nums,0,n,1);


        
    }
}