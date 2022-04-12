import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < num; i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0 && !st.isEmpty()){
                st.pop();
            }
            else if(num!=0){
                st.push(input);
            }
        }
        while(!st.isEmpty()){
            answer += st.pop();
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}