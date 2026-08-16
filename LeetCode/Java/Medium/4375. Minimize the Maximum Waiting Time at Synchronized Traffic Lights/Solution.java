class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = 0;

        for (int light : lights) {
            maxGreen = Math.max(maxGreen, light);
        }

        int ans = 0;

        for (int time : arrivalTime) {
            int r = time % period;

            if (r >= maxGreen) {
                ans = Math.max(ans, period - r);
            }
        }

        return ans;
    }
}