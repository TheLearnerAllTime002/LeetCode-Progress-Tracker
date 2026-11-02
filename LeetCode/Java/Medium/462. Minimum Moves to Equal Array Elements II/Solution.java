

class Solution {
    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int mid = nums[n / 2];

        int moves = 0;

        for (int i = 0; i < n / 2; i++) {
            moves += Math.abs(nums[i] - mid);
            moves += Math.abs(nums[n - 1 - i] - mid);
        }

        return moves;
    }
}