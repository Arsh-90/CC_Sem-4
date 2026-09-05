class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int sum=0;
        int res=Integer.MAX_VALUE;
        int len=0;
        int low=0;
        int high=0;
        for(high=0;high<n;high++){
            sum+=nums[high];
            while(sum>=target){
                 len=high-low+1;
                 res=Math.min(res,len);
                
                sum-=nums[low];
            low++;

            }
            
            
            
            

        }
        if(res==Integer.MAX_VALUE)
          return 0;

        return res;
    }
}