class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {

            int[] a = maxSubsequence(nums1, i);
            int[] b = maxSubsequence(nums2, k - i);

            int[] candidate = merge(a, b);

            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }

        return ans;
    }

    // Get maximum subsequence of length k
    private int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;
        int[] stack = new int[k];

        int top = 0;
        int remove = n - k;

        for (int num : nums) {

            while (top > 0 &&
                   stack[top - 1] < num &&
                   remove > 0) {

                top--;
                remove--;
            }

            if (top < k) {
                stack[top++] = num;
            } else {
                remove--;
            }
        }

        return stack;
    }

    // Merge two subsequences to get maximum number
    private int[] merge(int[] a, int[] b) {

        int[] res = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int r = 0;

        while (i < a.length || j < b.length) {

            if (greater(a, i, b, j)) {
                res[r++] = a[i++];
            } else {
                res[r++] = b[j++];
            }
        }

        return res;
    }

    // Compare a[i...] and b[j...]
    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length) {

            if (a[i] > b[j])
                return true;

            if (a[i] < b[j])
                return false;

            i++;
            j++;
        }

        return (a.length - i) > (b.length - j);
    }
}
