import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 좋은단어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> st = new Stack<>();
        
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String ab = br.readLine();
            for(int j = 0; j < ab.length(); j++){
                if(st.empty() || st.peek()!=ab.charAt(i)) st.push(ab.charAt(i));
                while(true){
                }
            }
        }
        br.close();
        bw.close();
    }
}