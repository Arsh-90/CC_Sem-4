class Solution {
public:
    int trap(vector<int>& height) {
        
    int left = 1;
    int right = height.size() - 2;

    int lMax = height[left - 1];
    int rMax = height[right + 1];

    int res = 0;
    while (left <= right) {
      
        if (rMax <= lMax) {
          
            res += max(0, rMax -height[right]);

            
            rMax = max(rMax, height[right]);

            
            right -= 1;
        } else { 
           
            res += max(0, lMax - height[left]);

            lMax = max(lMax, height[left]);
            left += 1;
        }
    }
    return res;
}
};

