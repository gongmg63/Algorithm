package x03;

import java.io.*;

public class 애너그램만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] arr = new int[26];
        int ret = 0;

        for (int i = 0; i < str1.length(); ++i)
            arr[str1.charAt(i) - 97]++;
        for (int i = 0; i < str2.length(); ++i)
            arr[str2.charAt(i) - 97]--;
        for (int i = 0; i < 26; ++i)
            ret += Math.abs(arr[i]);
        bw.write(ret + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
