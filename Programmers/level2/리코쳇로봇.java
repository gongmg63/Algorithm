package level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 리코쳇로봇 {
    int min = 1000000000;
    boolean[][] isVisited;


    void bfsFindWay(String[] board, Triple startPoint) {
        Queue<Triple> q = new ArrayDeque<>();

        q.offer(startPoint);
        while (!q.isEmpty()) {
            Triple point = q.poll();
            if (isVisited[point.x][point.y])
                continue;
            if (board[point.x].charAt(point.y) == 'G') {
                min = point.z;
                return ;
            }
            isVisited[point.x][point.y] = true;
            q.offer(up(board, point, point.z + 1));
            q.offer(down(board, point, point.z + 1));
            q.offer(left(board, point, point.z + 1));
            q.offer(right(board, point, point.z + 1));
        }
        min = -1;
    }

    public int solution(String[] board) {
        Triple startPoint = null;

        isVisited = new boolean[board.length][board[0].length()];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length(); ++j) {
                if (board[i].charAt(j) == 'R')
                    startPoint = new Triple(i, j);
            }
        }

        bfsFindWay(board, startPoint);
        return min;
    }

    class Triple {
        public int x; // up down
        public int y; // left right
        public int z; // depth

        Triple(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    Triple up(String[] board, Triple point, int num) {
        int x = point.x;
        int y = point.y;

        while (x > 0) {
            if (board[x - 1].charAt(y) == 'D')
                break;
            --x;
        }
        return new Triple(x, y, num);
    }
    Triple down(String[] board, Triple point, int num) {
        int x = point.x;
        int y = point.y;

        while (x < board.length - 1) {
            if (board[x + 1].charAt(y) == 'D')
                break;
            ++x;
        }
        return new Triple(x, y, num);
    }
    Triple left(String[] board, Triple point, int num) {
        int x = point.x;
        int y = point.y;

        while (y > 0) {
            if (board[x].charAt(y - 1) == 'D')
                break;
            --y;
        }
        return new Triple(x, y, num);
    }
    Triple right(String[] board, Triple point, int num) {
        int x = point.x;
        int y = point.y;

        while (y < board[x].length() - 1) {
            if (board[x].charAt(y + 1) == 'D')
                break;
            ++y;
        }
        return new Triple(x, y, num);
    }
}
