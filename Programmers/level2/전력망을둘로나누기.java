package level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 전력망을둘로나누기 {
    public int bfs(int start, boolean[][] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] isVisit = new boolean[graph.length + 1];
        int node = 0;

        q.offer(start);
        isVisit[start] = true;
        while (!q.isEmpty()) {
            int present = q.poll();
            ++node;
            for(int i = 1; i < graph[start].length; ++i) {
                if (graph[present][i] && !isVisit[i]) {
                    q.offer(i);
                    isVisit[i] = true;
                }
            }
        }
        return node;
    }
    public int solution(int n, int[][] wires) {
        int answer = 1000;

        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] line : wires) {
            graph[line[0]][line[1]] = true;
            graph[line[1]][line[0]] = true;
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (graph[i][j]) {
                    graph[i][j] = false;
                    graph[j][i] = false;

                    int tree1 = bfs(i, graph);
                    int tree2 = bfs(j, graph);

                    answer = Math.min(answer, Math.abs(tree1 - tree2));

                    graph[i][j] = true;
                    graph[j][i] = true;
                }
            }
        }

        return answer;
    }
}
