class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // First half
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        // Second half
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // Odd number of '?' -> Alice gets the decisive advantage
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        int sumDiff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;

        // Bob wins only when the difference can be perfectly balanced
        return sumDiff != 9 * qDiff / 2;
    }
}