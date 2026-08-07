class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)
        return x;
        int left=1;
        int right=x;
        int answer=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            long sqr=1L*mid*mid;

            if(x==sqr){
                return mid ;
            }
            else if (sqr<x){
                answer=mid ;
                left=mid+1;

            } else{
                right=mid-1;
            }
        }return answer;
    }
}