class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        // Remove redundant denominations.
        // If a coin is a multiple of another coin, its multiples
        // are already completely covered.
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && coins[i] % coins[j] == 0) {
                    removed[i] = true;
                    break;
                }
            }
        }

        int[] a = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                a[m++] = coins[i];
            }
        }

        // We can always get k values among multiples of the
        // smallest denomination, so this is a valid upper bound.
        long lo = 1;
        long hi = (long) a[0] * k;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, a, m) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private long count(long x, int[] coins, int n) {
        long result = 0;

        // Inclusion-exclusion over all non-empty subsets.
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    long g = gcd(lcm, coins[i]);

                    // lcm(lcm, coins[i]) = lcm / gcd * coins[i]
                    long next = lcm / g;

                    if (next > x / coins[i]) {
                        tooLarge = true;
                        break;
                    }

                    lcm = next * coins[i];

                    if (lcm > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) {
                continue;
            }

            long contribution = x / lcm;

            if ((bits & 1) == 1) {
                result += contribution;
            } else {
                result -= contribution;
            }
        }

        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}