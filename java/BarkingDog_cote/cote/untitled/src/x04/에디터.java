package x04;

import java.io.*;
import java.util.*;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<Character> st1 = new ArrayDeque<>();
        Deque<Character> st2 = new ArrayDeque<>();

        for (int i = 0; i < str.length(); ++i)
            st1.offerLast(str.charAt(i));

        for (int i = 0; i < n; ++i) {
            String command = br.readLine();

            switch (command) {
                case "L":
                    if (st1.peekLast() != null)
                        st2.offerLast(st1.pollLast());
                    break;
                case "D":
                    if (st2.peekLast() != null)
                        st1.offerLast(st2.pollLast());
                    break;
                case "B":
                    st1.pollLast();
                    break;
                default: // P 인 경우
                    st1.offerLast(command.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st1.isEmpty())
            sb.append(st1.pollFirst());
        while (!st2.isEmpty())
            sb.append(st2.pollLast());
        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

// LinkedList 풀이, 위치까지 찾아가는 시간 때문에 시간초과..

//public class 에디터 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String str = br.readLine();
//        int n = Integer.parseInt(br.readLine());
//
//        List<Character> list = new LinkedList<>();
//        for (int i = 0; i < str.length(); ++i)
//            list.add(str.charAt(i));
//
//        int cursor = list.size();
//        String st;
//        char command;
//
//        for (int i = 0; i < n; ++i) {
//            st = br.readLine();
//
//            command = st.charAt(0);
//            switch (command) {
//                case 'L':
//                    if (cursor != 0)
//                        cursor--;
//                    break;
//                case 'D':
//                    if (cursor != list.size())
//                        cursor++;
//                    break;
//                case 'B':
//                    if (cursor != 0 && !list.isEmpty())
//                        list.remove(--cursor);
//                    break;
//                case 'P':
//                    char message = st.charAt(2);
//                    if (cursor != list.size())
//                        list.add(cursor++, message);
//                    else {
//                        list.add(message);
//                        cursor++;
//                    }
//                    break;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (Character c : list)
//            sb.append(c);
//        bw.write(sb.toString() + "\n");
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
