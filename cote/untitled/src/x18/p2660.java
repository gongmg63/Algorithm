package x18;

import java.io.*;
import java.util.*;

//그래프
public class p2660 {
    static int[][] graph;
    static int[][] distGraph;
    static int n;

    static void bfs() {
        for (int i = 1; i < n + 1; ++i) {
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 1; j < n + 1; ++j) {
                    if (graph[cur][j] == 0 || distGraph[i][j] != 0 || i == j)
                        continue;
                    distGraph[i][j] = distGraph[i][cur] + 1;
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        distGraph = new int[n + 1][n + 1];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (node1 == -1 && node2 == -1)
                break;

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        int minDist = 51;
        for (int i = 1; i < n + 1; ++i) {
            bfs();
            Arrays.sort(distGraph[i]);
            minDist = Math.min(minDist, distGraph[i][n]);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n + 1; ++i) {
            if (distGraph[i][n] == minDist)
                arr.add(i);
        }

        bw.write(minDist + " " + arr.size() + "\n");
        for (int num : arr)
            bw.write(num + " ");
        bw.write("\n");

        br.close();
        bw.close();
    }
}
