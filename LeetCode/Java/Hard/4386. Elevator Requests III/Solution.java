class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        int N = 1 << m;

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[N][m];

        for (long[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }

        // First move from start to any request.
        for (int i = 0; i < m; i++) {
            int floor = requests[i][1];

            long time = Math.max(
                    (long) Math.abs(start - floor),
                    (long) requests[i][0]);

            int mask = collect(
                    0,
                    start,
                    floor,
                    time,
                    requests);

            dp[mask][i] = Math.min(dp[mask][i], time);
        }

        int full = N - 1;
        long ans = INF;

        for (int mask = 0; mask < N; mask++) {
            for (int last = 0; last < m; last++) {
                if (dp[mask][last] == INF)
                    continue;

                long time = dp[mask][last];

                if (mask == full) {
                    ans = Math.min(ans, time);
                    continue;
                }

                int currentFloor = requests[last][1];

                for (int next = 0; next < m; next++) {
                    if ((mask & (1 << next)) != 0)
                        continue;

                    int nextFloor = requests[next][1];

                    long travel = Math.abs(currentFloor - nextFloor);
                    long arrival = time + travel;

                    // We may wait at the destination until this request arrives.
                    long finish = Math.max(
                            arrival,
                            (long) requests[next][0]);

                    int newMask = collect(
                            mask,
                            currentFloor,
                            nextFloor,
                            finish,
                            requests);

                    dp[newMask][next] = Math.min(dp[newMask][next], finish);
                }
            }
        }

        return ans;
    }

    private int collect(
            int mask,
            int from,
            int to,
            long finish,
            int[][] requests) {
        for (int i = 0; i < requests.length; i++) {
            if ((mask & (1 << i)) != 0)
                continue;

            int floor = requests[i][1];

            // Is this floor on our path?
            if (floor >= Math.min(from, to) &&
                    floor <= Math.max(from, to)) {

                // Time at this floor while traveling.
                long visitTime = finish - Math.abs(to - floor);

                if (visitTime >= requests[i][0]) {
                    mask |= (1 << i);
                }
            }
        }

        return mask;
    }
}