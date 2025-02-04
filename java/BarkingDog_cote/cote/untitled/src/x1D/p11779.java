package x1D;

import java.io.*;
import java.util.*;

//다익스트라 알고리즘
public class p11779 {
    static int n, m, start, end;
    static ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    static int[] cost;
    static int[] pre;

    static class Pair implements Comparable<Pair>{
        public int vertex;
        public int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(weight, pair.weight);
        }
    }

    static void dijkstra() {
        Queue<Pair> pq = new PriorityQueue<>();
        cost[start] = pre[start] = 0;
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cost[cur.vertex] != cur.weight) continue; // 둘이 같으면 그 정점까지의 최단거리
            for (Pair next : graph.get(cur.vertex)) { // cur정점에서 이동할 수 있는 모든 마을 탐색
                if (cost[next.vertex] > cost[cur.vertex] + next.weight) {
                    cost[next.vertex] = cost[cur.vertex] + next.weight;
                    pre[next.vertex] = cur.vertex;
                    pq.add(new Pair(next.vertex, cost[next.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        Arrays.fill(cost, 100000001);
        pre = new int[n + 1];
        for (int i = 0; i < n + 1; ++i)
            graph.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Pair(vertex2, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        ArrayList<Integer> path = new ArrayList<>();
        path.add(end);
        int tmp = end;
        while (start != tmp) {
            tmp = pre[tmp];
            path.add(tmp);
        }
        bw.write(cost[end] + "\n");
        bw.write(path.size() + "\n");
        for (int i = path.size() - 1; i >= 0; --i)
            bw.write(path.get(i) + " ");
        bw.write("\n");

        br.close();
        bw.close();
    }
}
