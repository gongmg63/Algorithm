package x04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//백스페이스 = -
//화살표 = <, >
public class 키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashSet<Character> others = new HashSet<>();
        others.add('-');
        others.add('<');
        others.add('>');
        for (int i = 0; i < n; ++i) {
            String password = br.readLine();

            List<Character> list = new LinkedList<>();
            int pointer = 0;
            for (int j = 0; j < password.length(); ++j) {
                char c = password.charAt(j);
                if (!others.contains(c)){
                    if (pointer == list.size()) {
                        list.add(c);
                        pointer++;
                    }
                    else
                        list.add(pointer++, c);
                }
                else {
                    switch (c) {
                        case '-':
                            if (pointer != 0)
                                list.remove(--pointer);
                            break;
                        case '<':
                            if (pointer > 0)
                                pointer--;
                            break;
                        case '>':
                            if (pointer < list.size())
                                pointer++;
                            break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character ch : list)
                sb.append(ch);
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
