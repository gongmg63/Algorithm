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
public class 미로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> q = new LinkedList<>();
        int[][] maze  = new int[102][102];
        int[][] num = new int[102][102];
        Boolean[][] vis = new Boolean[102][102];
        int[] ud = {1,0,-1,0};
        int[] lr = {0,1,0,-1};
        for(int i = 0; i < 102; i++){
            for(int j = 0; j < 102; j++){
                vis[i][j]=false;
            }
        }
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        String[] mazeinput = new String[x];
        for(int i = 0; i < x; i++){
            mazeinput[i] = br.readLine();
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                maze[i][j] = Character.getNumericValue(mazeinput[i].charAt(j));
            }
        }
        q.offer(new Pair(0,0));
        vis[0][0] = true;
        num[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = new Pair(q.peek().x,q.peek().y);
            q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = p.x + ud[dir];
                int ny = p.y + lr[dir];
                if(nx < 0 || nx >= x || ny < 0 || ny >= y) continue;
                if(vis[nx][ny] || maze[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                num[nx][ny] = num[p.x][p.y]+1;
                q.offer(new Pair(nx, ny));
            }
        }
        bw.write(String.valueOf(num[x-1][y-1]));
        br.close();
        bw.close();
    }
}