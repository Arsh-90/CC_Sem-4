class Solution {
    public int[] twoSum(int[] nums, int target) {

        int []res =new int[2];
        int n =nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int cmp=target-nums[i];
            if(mp.containsKey(cmp)){
                return new int[]{mp.get(cmp),i};
            }
            mp.put(nums[i],i);
        }return res;
}}