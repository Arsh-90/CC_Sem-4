class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n =nums.length;
        Arrays.sort(nums);
        int closestsum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int low =i+1;
            int high=n-1;
            while(low<high){

            
            int sum=nums[i]+nums[low]+nums[high];
            int diff=Math.abs(target-sum);

            if(diff<min){
                min=diff;
                closestsum=sum;
            
            }
            if(sum==target)
            return sum;

            else if(sum<target)
            low++;

            else
            high--;}
                
        }return closestsum;
    }
}