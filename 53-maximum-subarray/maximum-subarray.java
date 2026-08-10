class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = nums[0];
        int saxi = nums[0];

        for (int i = 1; i < nums.length; i++) {
            saxi = Math.max(nums[i], nums[i] + saxi);
            maxi = Math.max(saxi, maxi);
        }
        return maxi;
    }
}