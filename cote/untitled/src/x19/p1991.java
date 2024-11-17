package x19;

import java.io.*;
import java.util.StringTokenizer;

//트리
public class p1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static char[] lc;
    static char[] rc;
    static char[] parent;

    static void preorder(int parentIndex) throws IOException{
        bw.write((char)(parentIndex + 'A'));
        if (lc[parentIndex] != '.')
            preorder(lc[parentIndex] - 'A');
        if (rc[parentIndex] != '.')
            preorder(rc[parentIndex] - 'A');
    }

    static void inorder(int parentIndex) throws IOException{
        if (lc[parentIndex] != '.')
            inorder(lc[parentIndex] - 'A');
        bw.write((char)(parentIndex + 'A'));
        if (rc[parentIndex] != '.')
            inorder(rc[parentIndex] - 'A');
    }

    static void postorder(int parentIndex) throws IOException{
        if (lc[parentIndex] != '.')
            postorder(lc[parentIndex] - 'A');
        if (rc[parentIndex] != '.')
            postorder(rc[parentIndex] - 'A');
        bw.write((char)(parentIndex + 'A'));
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        lc = new char[n];
        rc = new char[n];
        parent = new char[n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            parent[i] = (char)(p - 'A');
            lc[p - 'A'] = l;
            rc[p - 'A'] = r;
        }
        preorder(0);
        bw.write("\n");
        inorder(0);
        bw.write("\n");
        postorder(0);
        bw.write("\n");
        br.close();
        bw.close();
    }
}
