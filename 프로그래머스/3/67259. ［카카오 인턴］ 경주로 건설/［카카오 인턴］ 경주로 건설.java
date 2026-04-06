import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int r, c, dir, cost;
        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static int[][][] dist;
    private static int R;
    private static int C;

    private static int bfs(int[][] board, int[][][] dist) {
        int[] dr = new int[] {-1, 1, 0, 0};
        int[] dc = new int[] {0, 0, -1, 1};

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.r == R - 1 && now.c == C - 1) return now.cost;

            for (int i = 0; i < 4; i++ ) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < R && nc < C && board[nr][nc] == 0) {
                    if (now.dir == 0 || now.dir == 1) {
                        if (i == 0 || i == 1) {
                            if (dist[nr][nc][i] > now.cost + 100) {
                                dist[nr][nc][i] = now.cost + 100;
                                queue.offer(new Node(nr, nc, i, now.cost + 100));
                            }
                        } else if (i == 2 || i == 3) {
                            if (dist[nr][nc][i] > now.cost + 600) {
                                dist[nr][nc][i] = now.cost + 600;
                                queue.offer(new Node(nr, nc, i, now.cost + 600));
                            }
                        }
                    } else if (now.dir == 2 || now.dir == 3) {
                        if (i == 2 || i == 3) {
                            if (dist[nr][nc][i] > now.cost + 100) {
                                dist[nr][nc][i] = now.cost + 100;
                                queue.offer(new Node(nr, nc, i, now.cost + 100));
                            }

                        } else if (i == 0 || i == 1) {
                            if (dist[nr][nc][i] > now.cost + 600) {
                                dist[nr][nc][i] = now.cost + 600;
                                queue.offer(new Node(nr, nc, i, now.cost + 600));
                            }
                        }
                    } else {
                        if (dist[nr][nc][i] > now.cost + 100) {
                            dist[nr][nc][i] = now.cost + 100;
                            queue.offer(new Node(nr, nc, i, now.cost + 100));
                        }

                    }
                }

            }

        }

        return -1;
    }
    public int solution(int[][] board) {
        R = board.length; C = board.length;
        dist = new int[R][C][4];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        return bfs(board, dist);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
    }
}