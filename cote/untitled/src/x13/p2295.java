package x13;

import java.io.*;
import java.util.*;

//세 수의 합
public class p2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        // a + b + c = k, (a + b) + c = k -> k - (a + b) = c
        Set<Integer> sumTwo = new HashSet<>();
        for (int i = 0; i < n; ++i)
            for (int j = i; j < n; ++j)
                sumTwo.add(arr[i] + arr[j]);

        for (int i = n - 1; i >= 0; --i) {
            Iterator<Integer> iter = sumTwo.iterator();
            int present;
            while (iter.hasNext()) {
                present = iter.next();
                if (Arrays.binarySearch(arr, arr[i] - present) >= 0) {
                    bw.write(arr[i] + "\n");
                    break;
                }
            }
            if (iter.hasNext())
                break;
        }

        br.close();
        bw.close();
    }
}
