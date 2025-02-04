import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> st = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String com = br.readLine();
            if(com.contains("push")){
                st.push(Integer.parseInt(com.substring(5)));
            }
            else if(com.equals("pop")){
                if(st.size()!=0){
                    bw.write(String.valueOf(st.pop()) + "\n");
                }
                else{
                    bw.write(String.valueOf(-1)+ "\n");
                }
            }
            else if(com.equals("size")){
                bw.write(String.valueOf(st.size())+ "\n");
            }
            else if(com.equals("empty")){
                if(st.empty()){
                    bw.write(String.valueOf(1)+ "\n");
                }
                else{
                    bw.write(String.valueOf(0)+ "\n");
                }
            }
            else if(com.equals("top")){
                if(st.size()!=0){
                    bw.write(String.valueOf(st.peek())+ "\n");
                }
                else{
                    bw.write(String.valueOf(-1)+ "\n");
                }
            }
        }
        br.close();
        bw.close();
    }   
}