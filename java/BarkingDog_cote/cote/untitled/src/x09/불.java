package x09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {

    static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] maze = new int[1001][1001];
        int[][] mazeFire = new int[1001][1001];
        for (int[] row : mazeFire)
            Arrays.fill(row, Integer.MAX_VALUE);

        boolean[][] isVisit = new boolean[1001][1001];

        Queue<Pair> q = new ArrayDeque<>();
        Queue<Pair> q2 = new ArrayDeque<>();
        Pair jStart = null;

        for (int i = 0; i < r; ++i) {
            String line = br.readLine();
            for (int j = 0; j < c; ++j) {
                if (line.charAt(j) == '#')
                    maze[i][j] = -1;
                else if (line.charAt(j) == 'J') {
                    maze[i][j] = 0;
                    q2.offer(new Pair(i, j));
                } else if (line.charAt(j) == 'F')  {
                    q.offer(new Pair(i, j));
                    maze[i][j] = -2;
                    mazeFire[i][j] = 0;
                } else
                    maze[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair present = q.poll();
            for (int i = 0; i < 4; ++i) {
                int x = present.x + dx[i];
                int y = present.y + dy[i];
                if (x < 0 || x >= r || y < 0 || y >= c)
                    continue;
                if (maze[x][y] == -1 || maze[x][y] == -2 || isVisit[x][y])
                    continue;
                q.offer(new Pair(x, y));
                mazeFire[x][y] = mazeFire[present.x][present.y] + 1;
                isVisit[x][y] = true;
            }
        }

        for (boolean[] vLine : isVisit)
            Arrays.fill(vLine, false);

        boolean impossible = true;

        while (!q2.isEmpty() && impossible) {
            Pair present = q2.poll();
            for (int i = 0; i < 4; ++i) {
                int x = present.x + dx[i];
                int y = present.y + dy[i];
                if (x < 0 || x >= r || y < 0 || y >= c) {
                    bw.write(maze[present.x][present.y] + 1 + "\n");
                    impossible = false;
                    break;
                }
                if (maze[x][y] == -1  || mazeFire[x][y] <= maze[present.x][present.y] + 1 || isVisit[x][y])
                    continue;
                q2.offer(new Pair(x, y));
                maze[x][y] = maze[present.x][present.y] + 1;
                isVisit[x][y] = true;
            }
        }
        if (impossible)
            bw.write("IMPOSSIBLE\n");

        bw.flush();
        bw.close();
        br.close();
    }
}