class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        // Count characters in s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Try to make the answer greater at the rightmost
        // possible position.
        for (int i = n - 1; i >= 0; i--) {

            int[] count = freq.clone();

            // Check whether target[0 ... i-1] can be formed.
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';

                if (count[c] == 0) {
                    possible = false;
                    break;
                }

                count[c]--;
            }

            if (!possible) {
                continue;
            }

            // Try to put the smallest character
            // greater than target[i].
            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (count[c] == 0) {
                    continue;
                }

                StringBuilder ans = new StringBuilder();

                // Keep the prefix same as target
                ans.append(target, 0, i);

                // Make this position greater
                ans.append((char) ('a' + c));

                count[c]--;

                // Add remaining characters in sorted order
                for (int k = 0; k < 26; k++) {
                    while (count[k] > 0) {
                        ans.append((char) ('a' + k));
                        count[k]--;
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }
}