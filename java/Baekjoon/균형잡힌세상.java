import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> st = new Stack<>();
        while(true){
            String sentence = br.readLine();
            if(sentence.charAt(0)=='.'){
                break;
            }
            Boolean isValid = true;
            for(int i = 0; i < sentence.length(); i++){
                if(sentence.charAt(i)=='(' || sentence.charAt(i)=='['){
                    st.push(sentence.charAt(i));
                }
                else if(sentence.charAt(i)==')'){
                    if(!st.empty() && st.peek()=='('){
                        st.pop();
                    }
                    else{
                        isValid = false;
                        break;
                    }
                }
                else if(sentence.charAt(i)==']'){
                    if(!st.empty() && st.peek()=='['){
                        st.pop();
                    }
                    else{
                        isValid = false;
                        break;
                    }
                }
            }
            if(!st.empty()) isValid = false;
            if(isValid) bw.write("yes\n");
            else bw.write("no\n");
            st.clear();
        }
        br.close();
        bw.close();
    }
}