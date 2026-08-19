class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>())
               .add(seat[1]);
        }

        int ans = (n - map.size()) * 2;

        for (Set<Integer> reserved : map.values()) {
            boolean left = true;   // 2,3,4,5
            boolean middle = true; // 4,5,6,7
            boolean right = true;  // 6,7,8,9

            for (int seat : reserved) {
                if (seat >= 2 && seat <= 5) left = false;
                if (seat >= 4 && seat <= 7) middle = false;
                if (seat >= 6 && seat <= 9) right = false;
            }

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}