class Solution {
    public int[] runningSum(int[] nums) {
        int n =nums.length;
        int[]ans=new int [n];
        int prev=0;
        for(int i=0;i<n;i++){
            ans[i]=nums[i]+prev;
            prev=ans[i];
        }return ans;
    }
}