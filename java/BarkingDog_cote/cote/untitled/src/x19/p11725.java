package x19;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//트리
public class p11725 {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] vis;
    static int[] parent;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            vis[cur] = true;
            for (int i = 0; i < graph.get(cur).size(); ++i) {
                if (vis[graph.get(cur).get(i)])
                    continue;
                parent[graph.get(cur).get(i)] = cur;
                q.offer(graph.get(cur).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        vis = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        bfs();
        for (int i = 2; i < n + 1; ++i)
            bw.write(parent[i] + "\n");

        br.close();
        bw.close();
    }
}
