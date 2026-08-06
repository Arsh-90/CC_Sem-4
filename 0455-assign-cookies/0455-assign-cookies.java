class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int n =g.length;
        int m=s.length;
        while(i<n &&j<m){
            if(s[j]>=g[i]){
                res++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }return res;

        
    }
}