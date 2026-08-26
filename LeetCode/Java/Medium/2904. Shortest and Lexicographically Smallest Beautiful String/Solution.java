class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();

        // Store positions of all '1's
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // Not enough 1's
        if (ones.size() < k) {
            return "";
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        // Consider every group of k consecutive 1's
        for (int i = 0; i + k - 1 < ones.size(); i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);

            int len = end - start + 1;
            String curr = s.substring(start, end + 1);

            if (len < minLen ||
                (len == minLen && (ans.isEmpty() || curr.compareTo(ans) < 0))) {
                minLen = len;
                ans = curr;
            }
        }

        return ans;
    }
}