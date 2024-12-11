import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class 회전하는큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new ArrayDeque<>();
        Iterator<Integer> iter = dq.iterator();
        Iterator<Integer> riter = dq.descendingIterator();
        
        String[] num = br.readLine().split(" ");
        String[] poplist = br.readLine().split(" ");
        int answer = 0;
        for(int i = 1; i <= Integer.parseInt(num[0]); i++){
            dq.add(i);
        }
        for(int i = 0; i < poplist.length; i++){
            int popnum = Integer.parseInt(poplist[i]);
            while(true){
                if(popnum==dq.peekFirst()){
                    dq.pollFirst();
                    break;
                }
                else {
                    int first = 0;
                    int firit = iter.next();
                    int last = 0;
                    int lastrit = riter.next();
                    while(popnum != firit){
                        first++;
                        firit = iter.next();
                    }
                    while(popnum != lastrit){
                        last++;
                        lastrit = riter.next();
                    }
                    if(first < last){
                        dq.addLast(dq.pollFirst());
                        answer++;
                    }
                    else if(first > last){
                        dq.addFirst(dq.pollLast());
                        answer++;
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}