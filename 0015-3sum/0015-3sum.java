class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n-2;i++){
            int target=-nums[i];
            if(i>0 && nums[i]==nums[i-1])
            continue;
            int low =i+1;
            int high=n-1;
            while(low<high){
                int sum=nums[low]+nums[high];
                if(sum==-nums[i]){
                    res.add(List.of(nums[i],nums[low],nums[high]));
                    low++;
                    high--;

                    while(low<high && nums[low]==nums[low-1])
                    low++;

                    while(low<high && nums[high]==nums[high+1])
                    high--;
                }
                else if(sum<target){
                    low++;
                }
                else
                high--;
            }

        }return res;
        
    }
}