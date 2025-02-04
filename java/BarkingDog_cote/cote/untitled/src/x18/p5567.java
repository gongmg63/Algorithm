package x18;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프
public class p5567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[][] graph;
    static int[] dist;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        dist[1] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i < n + 1; ++i) {
                if (graph[node][i] == 0 || dist[i] != 0)
                    continue;
                q.offer(i);
                dist[i] = dist[node] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        dist = new int[n + 1];

        // 본인을 기준으로 거리가 2(친구의 친구)인 정점 찾기
        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }
        bfs();
        int count = 0;
        for (int i = 1; i < n + 1; ++i) {
            if (dist[i] == 2 || dist[i] == 3)
                ++count;
        }
        bw.write(count + "\n");

        br.close();
        bw.close();
    }
}
