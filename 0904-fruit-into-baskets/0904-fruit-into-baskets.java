class Solution {
    public int totalFruit(int[] fruits) {
        int n =fruits.length;
        int low=0;
        int high=0;
        int res=Integer.MIN_VALUE;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(high=0;high<n;high++){
            mp.put(fruits[high],mp.getOrDefault(fruits[high],0)+1);
            while(mp.size()>2){
                mp.put(fruits[low],mp.get(fruits[low])-1);
                if(mp.get(fruits[low])==0)
                mp.remove(fruits[low]);

                low++;
            }
                int len=high-low+1;
                res=Math.max(len,res);
            

        }
        if(res==Integer.MIN_VALUE)
        return -1;

        return res;
    }
}