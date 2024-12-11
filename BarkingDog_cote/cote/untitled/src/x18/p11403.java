package x18;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프
public class p11403 {
    static int[][] graph;
    static int[][] ret;
    static int n;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 0; j < n; ++j) {
                    if (graph[cur][j] == 0 || ret[i][j] == 1)
                        continue;
                    ret[i][j] = 1;
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        ret = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        bfs();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                bw.write(ret[i][j] + " ");
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
