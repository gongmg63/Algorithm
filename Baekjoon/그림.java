import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class 그림 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> q = new LinkedList<>();
        int[][] board = new int[502][502];
        Boolean[][] vis = new Boolean[502][502];
        for(int i = 0; i < 502; i++){
            for(int j = 0; j < 502; j++){
                vis[i][j] = false;
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int pn = 0;
        int mxps = 0;

        String[] boardsize = br.readLine().split(" ");
        int n = Integer.parseInt(boardsize[0]);
        int m = Integer.parseInt(boardsize[1]);

        for(int i=0; i < n; i++){
            String[] nn = br.readLine().split(" ");
            for(int j=0; j < m; j++){
                board[i][j] = Integer.parseInt(nn[j]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0 || vis[i][j]) continue;
                vis[i][j] = true;
                pn++;
                q.offer(new Pair(i,j));
                int ps = 0;
                while(!q.isEmpty()){
                    Pair p = new Pair(q.peek().x,q.peek().y);
                    q.poll();
                    ps++;
                    for(int dir = 0; dir < 4; dir++){
                        int nx = p.x + dx[dir];
                        int ny = p.y + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || board[nx][ny] != 1) continue;
                        vis[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
                if(mxps < ps) mxps=ps;
            }
        }
        bw.write(String.valueOf(pn)+"\n");
        bw.write(String.valueOf(mxps)+"\n");
        br.close();
        bw.close();
    }
}