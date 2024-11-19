package x1D;

import java.io.*;
import java.util.*;

//다익스트라 알고리즘
public class p1753 {
    static int v, e, s;
    static int[][] graph;
    static ArrayList<ArrayList<Pair>> listGraph = new ArrayList<>();
    static int[] route;
    static boolean[] selectedRoute;

    static class Pair implements Comparable<Pair> {
        public int weight;
        public int vertex;

        Pair(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.weight, pair.weight);
        }
    }

    static void dijkstra() {
        Arrays.fill(route, 600000001);
        route[s] = 0;
        Queue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(route[s], s));
        // 최단 거리 확정
        // 최단 거리 에서 갈 수 있는 모든 길에 대한 계산 후 찾은 최단 거리 삽입
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (route[cur.vertex] != cur.weight) continue;

            for (Pair pair : listGraph.get(cur.vertex)) {
                if (route[pair.vertex] > route[cur.vertex] + pair.weight) {
                    route[pair.vertex] = route[cur.vertex] + pair.weight;
                    pq.add(new Pair(route[pair.vertex], pair.vertex));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());

        for (int i = 0; i < v + 1; ++i)
            listGraph.add(new ArrayList<>());
        route = new int[v + 1];
        selectedRoute = new boolean[v + 1];

        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            listGraph.get(vertex1).add(new Pair(weight, vertex2));
        }

        dijkstra();
        for (int i = 1; i < v + 1; ++i) {
            if (route[i] == 600000001)
                bw.write("INF\n");
            else
                bw.write(route[i] + "\n");
        }

        br.close();
        bw.close();
    }
}
