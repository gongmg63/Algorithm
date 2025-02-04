package x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder ret = new StringBuilder();
    static boolean[] isVisited = new boolean[15];

    static boolean checkPassword(StringBuilder sb) {
        int consonant = 0, vowel = 0;

        for (int i = 0; i < sb.length(); ++i) {
            if ("aeiou".contains(String.valueOf(sb.charAt(i))))
                ++consonant;
            else
                ++vowel;
        }
        if (consonant > 0 && vowel > 1)
            return true;
        return false;
    }

    static boolean checkAscending(StringBuilder sb) {
        for (int i = 1; i < sb.length(); ++i) {
            if (sb.charAt(i) < sb.charAt(i - 1))
                return false;
        }
        return true;
    }
    static void backTracking(int l, int c, StringBuilder sb, int index) throws IOException{
        if (ret.length() == l) {
            if (checkPassword(ret))
                bw.write(ret.toString() + "\n");
            return ;
        }
        for (int i = index; i < c; ++i) {
            if (!isVisited[i]) {
                ret.append(sb.charAt(i));
                isVisited[i] = true;
                backTracking(l, c, sb, i + 1);
                isVisited[i] = false;
                ret.deleteCharAt(ret.length() - 1);
            }
        }
    }
    // 최소 한 개의 모음과 두 개의 자음, 오름차순
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens())
            sb.append(st.nextToken());

        char[] sortStr = sb.toString().toCharArray();
        Arrays.sort(sortStr);
        sb = new StringBuilder();
        for (char value : sortStr)
            sb.append(value);

        backTracking(l, c, sb, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}
