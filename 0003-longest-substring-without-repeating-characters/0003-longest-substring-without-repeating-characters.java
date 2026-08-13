class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        int high=0;
        int res=0;
        int n =s.length();
        HashMap<Character,Integer>f=new HashMap<>();
        for(high=0;high<n;high++){
            char ch =s.charAt(high);
            f.put(ch,f.getOrDefault(ch,0)+1);
            int k=high-low+1;
            while(k>f.size()){
                char leftchar=s.charAt(low);
                f.put(leftchar,f.get(leftchar)-1);
                if(f.get(leftchar)==0)
                f.remove(leftchar);

                low++;
                k=high-low+1;

            }
            int len=high-low+1;
            res=Math.max(res,len);

        }return res;
    }
}