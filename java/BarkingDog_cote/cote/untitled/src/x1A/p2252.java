package x1A;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//위상 정렬
public class p2252 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] degree;
    static ArrayList<Integer> order = new ArrayList<>();

    static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; ++i) {
            if (degree[i] == 0) {
                q.offer(i);
                order.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); ++i) {
                if (--degree[graph.get(cur).get(i)] == 0) {
                    q.offer(graph.get(cur).get(i));
                    order.add(graph.get(cur).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        degree = new int[n + 1];
        for (int i = 0; i < n + 1; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            ++degree[node2];
        }
        topologySort();
        for (int i : order)
            bw.write(i + " ");
        bw.write("\n");
        br.close();
        bw.close();
    }
}
