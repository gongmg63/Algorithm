package level2;

import java.util.*;

public class 배달 {
    ArrayList<ArrayList<Pair>> graph;

    class Pair implements Comparable<Pair>{
        int end;
        int weight;

        Pair(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(weight, pair.weight);
        }
    }

    public int dijkstra(int n, int k) {
        int ret = 0;
        int[] route = new int[n + 1];
        Arrays.fill(route, 500001);
        route[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (route[cur.end] != cur.weight) continue;

            for (Pair next : graph.get(cur.end)) {
                if (route[next.end] > route[cur.end] + next.weight) {
                    route[next.end] = route[cur.end] + next.weight;
                    pq.offer(new Pair(next.end, route[next.end]));
                }
            }
        }
        for (int j : route) {
            if (j <= k)
                ++ret;
        }
        return ret;
    }

    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; ++i)
            graph.add(new ArrayList<>());

        for (int[] r : road) {
            int node1 = r[0];
            int node2 = r[1];
            int weight = r[2];

            graph.get(node1).add(new Pair(node2, weight));
            graph.get(node2).add(new Pair(node1, weight));
        }

        return dijkstra(N, K);
    }
}
