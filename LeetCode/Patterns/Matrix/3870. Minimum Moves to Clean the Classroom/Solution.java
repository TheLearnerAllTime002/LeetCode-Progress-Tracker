import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = -1, sc = -1;
        int litterCount = 0;

        // Assign each litter cell a bit.
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;

        if (litterCount == 0) {
            return 0;
        }

        /*
         * State:
         *   row, col   -> current position
         *   mask       -> collected litter
         *   energyLeft -> remaining energy
         */

        int masks = 1 << litterCount;

        // dist[row][col][mask][energy]
        int[][][][] dist = new int[m][n][masks][energy + 1];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int mask = 0; mask < masks; mask++) {
                    Arrays.fill(dist[r][c][mask], -1);
                }
            }
        }

        Queue<State> queue = new ArrayDeque<>();

        int startMask = 0;

        if (litterId[sr][sc] != -1) {
            startMask |= 1 << litterId[sr][sc];
        }

        dist[sr][sc][startMask][energy] = 0;
        queue.offer(new State(sr, sc, startMask, energy));

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            int r = cur.r;
            int c = cur.c;
            int mask = cur.mask;
            int e = cur.energy;

            int moves = dist[r][c][mask][e];

            // All litter collected.
            if (mask == fullMask) {
                return moves;
            }

            // Cannot move with zero energy.
            if (e == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside grid.
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle.
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = e - 1;

                // Reset energy when entering R.
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                int newMask = mask;

                // Collect litter.
                if (litterId[nr][nc] != -1) {
                    newMask |= 1 << litterId[nr][nc];
                }

                // Already visited this exact state.
                if (dist[nr][nc][newMask][newEnergy] != -1) {
                    continue;
                }

                dist[nr][nc][newMask][newEnergy] = moves + 1;

                queue.offer(
                    new State(nr, nc, newMask, newEnergy)
                );
            }
        }

        return -1;
    }

    static class State {
        int r, c, mask, energy;

        State(int r, int c, int mask, int energy) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
        }
    }
}