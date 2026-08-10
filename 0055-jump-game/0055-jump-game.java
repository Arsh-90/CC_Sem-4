class Solution {
    public boolean canJump(int[] nums) {
        int n =nums.length;
        int reach=0;
        int i=0;
        while(i<n){  

            if(i>reach)
            return false;

            if(i==n-1)
            return true;
            reach=Math.max(reach,i+nums[i]);
            

i++;
        }return false;
    } 
}