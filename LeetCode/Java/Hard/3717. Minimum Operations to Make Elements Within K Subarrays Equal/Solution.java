class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;
        for (int v : sorted) {
            if (m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        Fenwick count = new Fenwick(m);
        Fenwick sum = new Fenwick(m);

        int[] id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
        }

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            count.add(id[i], 1);
            sum.add(id[i], nums[i]);
        }

        for (int i = 0; i <= n - x; i++) {
            int mid = count.kth((x + 1) / 2);
            long median = sorted[mid - 1];

            long leftCount = count.query(mid);
            long leftSum = sum.query(mid);
            long totalSum = sum.query(m);

            long rightCount = x - leftCount;
            long rightSum = totalSum - leftSum;

            cost[i] = median * leftCount - leftSum
                    + rightSum - median * rightCount;

            if (i < n - x) {
                count.add(id[i], -1);
                sum.add(id[i], -nums[i]);

                count.add(id[i + x], 1);
                sum.add(id[i + x], nums[i + x]);
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }

    class Fenwick {
        long[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void add(int i, long val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        long query(int i) {
            long res = 0;

            while (i > 0) {
                res += tree[i];
                i -= i & -i;
            }

            return res;
        }

        int kth(long target) {
            int idx = 0;

            for (int bit = Integer.highestOneBit(n);
                 bit > 0; bit >>= 1) {

                int next = idx + bit;

                if (next <= n && tree[next] < target) {
                    idx = next;
                    target -= tree[next];
                }
            }

            return idx + 1;
        }
    }
}