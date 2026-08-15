class Solution {
    public int longestSubsequence(int[] nums) {
        int XOR = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            XOR ^= nums[i];
            if (nums[i] == 0) {
                count++;
            }
        }

        if (XOR != 0) {
            return n;
        } else {
            if (count == n)
                return 0;
        }
        return n - 1;
    }
}