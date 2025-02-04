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
public class 토마토 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> q = new LinkedList<>();
        int[][] tomatobox = new int[1002][1002];
        int[][] day = new int[1002][1002];
        Boolean[][] vis = new Boolean[1002][1002];
        for(int i = 0; i < 1002; i++){
            for(int j = 0; j < 1002; j++){
                vis[i][j]=false;
            }
        }
        int[] ud = {1,0,-1,0};
        int[] lr = {0,1,0,-1};
        String[] xy = br.readLine().split(" ");
        int y = Integer.parseInt(xy[0]);
        int x = Integer.parseInt(xy[1]);

        int zero = 0;

        for(int i = 0; i < x; i++){
            String[] tomatoinput = br.readLine().split(" ");
            for(int j = 0; j < y; j++){
                tomatobox[i][j] = Integer.parseInt(tomatoinput[j]);
                if(tomatobox[i][j]==1){
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                    day[i][j]=0;
                }
                if(tomatobox[i][j]==0)
                    zero++;
            }
        }
        
        int max = 0;

        while(!q.isEmpty()){
            Pair p = new Pair(q.peek().x,q.peek().y);
            q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = p.x + ud[dir];
                int ny = p.y + lr[dir];
                if(nx < 0 || nx >= x || ny < 0 || ny >= y) continue;
                if(vis[nx][ny] || tomatobox[nx][ny] != 0) continue;
                vis[nx][ny] = true;
                day[nx][ny] = day[p.x][p.y]+1;
                zero--;
                if(day[nx][ny] > max){
                    max = day[nx][ny];
                }
                q.offer(new Pair(nx, ny));
            }
        }
        if(zero == 0)
            bw.write(String.valueOf(max));
        else
            bw.write("-1");
        br.close();
        bw.close();
    }
}