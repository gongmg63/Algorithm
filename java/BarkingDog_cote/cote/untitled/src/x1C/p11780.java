package x1C;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//플로이드 알고리즘
public class p11780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];

        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (graph[node1][node2] != 0)
                cost = Math.min(graph[node1][node2], cost);
            graph[node1][node2] = cost;
            next[node1][node2] = node2;
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (i == j) continue;
                if (graph[i][j] == 0)
                    graph[i][j] = 10000000;
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                for (int k = 1; k < n + 1; ++k) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                        next[j][k] = next[j][i];
                    }
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

        ArrayList<Integer> route = new ArrayList<>();
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (next[i][j] == 0)
                    bw.write("0\n");
                else {
                    int start = i;

                    route.add(start);
                    while (start != j) {
                        start = next[start][j];
                        route.add(start);
                    }
                    bw.write(route.size() + " ");
                    for (int k : route)
                        bw.write(k + " ");
                    route.clear();
                    bw.write("\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
