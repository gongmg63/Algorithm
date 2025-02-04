import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 덱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String command = br.readLine();
            if(command.contains("push_front")){
                int pushnumber = Integer.parseInt(command.substring(11));
                dq.offerFirst(pushnumber);
            }
            else if(command.contains("push_back")){
                int pushnumber = Integer.parseInt(command.substring(10));
                dq.offerLast(pushnumber);
            }
            else if(command.contains("pop_front")){
                if(dq.size() > 0){
                    bw.write(String.valueOf(dq.pollFirst())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
            else if(command.contains("pop_back")){
                if(dq.size() > 0){
                    bw.write(String.valueOf(dq.pollLast())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
            else if(command.contains("size")){
                bw.write(String.valueOf(dq.size())+"\n");
            }
            else if(command.contains("empty")){
                if(dq.size()>0){
                    bw.write("0\n");
                }
                else{
                    bw.write("1\n");
                }
            }
            else if(command.contains("front")){
                if(dq.size()>0){
                    bw.write(String.valueOf(dq.peekFirst())+"\n");
                }
                else{
                    bw.write("-1\n");
                }
            }
            else if(command.contains("back")){
                if(dq.size()>0){
                    bw.write(String.valueOf(dq.peekLast())+"\n");
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