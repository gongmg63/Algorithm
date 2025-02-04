package x13;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//차집합
public class p1822 {
    static boolean binarySearch(int[] arr, int x) {
        int st = 0, end = arr.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;
            if (x > arr[mid]) {
                st = mid + 1;
            } else if (x == arr[mid]){
                return true;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        int[] arrA = new int[nA];
        int[] arrB = new int[nB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; ++i)
            arrA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; ++i)
            arrB[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrB);
        Arrays.sort(arrA);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nA; ++i) {
            if (!binarySearch(arrB, arrA[i])) {
                list.add(arrA[i]);
            }
        }
        bw.write(list.size() + "\n");
        for (int i = 0; i < list.size(); ++i)
            bw.write(list.get(i) + " ");
        bw.write("\n");

        bw.close();
        br.close();
    }
}
