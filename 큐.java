import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int tail = 0;
        for(int i = 0; i < num; i++){
            String command = br.readLine();
            if(command.contains("push")){
                int pushnumber = Integer.parseInt(command.substring(5));
                q.offer(pushnumber);
                tail = pushnumber; 
            }
            else if(command.contains("pop")){
                if(q.size() > 0){
                    bw.write(String.valueOf(q.poll())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
            else if(command.contains("size")){
                bw.write(String.valueOf(q.size())+"\n");
            }
            else if(command.contains("empty")){
                if(q.size()>0){
                    bw.write("0\n");
                }
                else{
                    bw.write("1\n");
                }
            }
            else if(command.contains("front")){
                if(q.size()>0){
                    bw.write(String.valueOf(q.peek())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
            else if(command.contains("back")){
                if(q.size()>0){
                    bw.write(String.valueOf(tail)+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}
