import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class 에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        LinkedList<String> lstr = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            lstr.add(String.valueOf(str.charAt(i)));
        }
        int comnum = Integer.parseInt(br.readLine());
        int n = str.length();
        for(int i = 0; i < comnum; i++){
            String command = br.readLine();
            
            if(command.charAt(0)=='P'){
                lstr.add(n,command.substring(2));
                n+=command.substring(2).length();
            }
            else if(command.charAt(0)=='L'){
                if(n!=0){                    
                    n--;
                }
            }
            else if(command.charAt(0)=='D'){
                if(n==str.length()-1){
                    n++;
                }
            }
            else if(command.charAt(0)=='B'){
                if(n!=0){
                    lstr.remove(n);
                }
            }
        }
        for(int i = 0; i < lstr.size(); i++){
            bw.write(lstr.get(i));
        }
        br.close();
        bw.close();
    }
}
