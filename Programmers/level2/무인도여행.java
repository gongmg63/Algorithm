package level2;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class 무인도여행 {
    Queue<Integer> pq = new PriorityQueue<>();

    class Pair {
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void bfs(String[] maps) {
        Queue<Pair> q = new ArrayDeque<>();

        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < maps.length; ++i) {
            for (int j = 0; j < maps[i].length(); ++j) {
                if (maps[i].charAt(j) != 'X' && !isVisited[i][j]) {
                    q.offer(new Pair(i, j));
                    isVisited[i][j] = true;
                    int day = 0;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        day += maps[cur.x].charAt(cur.y) - '0';
                        for (int k = 0; k < 4; ++k) {
                            if (cur.x + dx[k] < 0 || cur.x + dx[k] >= maps.length ||
                                    cur.y + dy[k] < 0 || cur.y + dy[k] >= maps[i].length()) continue;
                            if (maps[cur.x + dx[k]].charAt(cur.y + dy[k]) == 'X') continue;
                            if (isVisited[cur.x + dx[k]][cur.y + dy[k]]) continue;
                            q.offer(new Pair(cur.x + dx[k], cur.y + dy[k]));
                            isVisited[cur.x + dx[k]][cur.y + dy[k]] = true;
                        }
                    }
                    pq.offer(day);
                }
            }
        }
    }

    public int[] solution(String[] maps) {
        int[] answer;

        bfs(maps);
        if (pq.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[pq.size()];
            for (int i = 0; !pq.isEmpty(); ++i) {
                answer[i] = pq.poll();
            }
        }
        return answer;
    }
}
