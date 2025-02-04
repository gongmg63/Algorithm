package x1C;

import java.io.*;
import java.util.StringTokenizer;

//플로이드 알고리즘
public class p11404 {
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (graph[node1][node2] != 0)
                cost = Math.min(graph[node1][node2], cost);
            graph[node1][node2] = cost;
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (i == j) continue;
                if (graph[i][j] == 0)
                    graph[i][j] = 10000000;
            }
        }

        for (int i = 1; i < n + 1; ++i) { // 거쳐갈 마을 선택
            for (int j = 1; j < n + 1; ++j) { // 출발할 마을
                for (int k = 1; k < n + 1; ++k) { // 도착할 마을
                    graph[j][k] = Math.min(graph[j][i] + graph[i][k], graph[j][k]);
                }
            }
        }
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (graph[i][j] == 10000000)
                    bw.write("0 ");
                else
                    bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
