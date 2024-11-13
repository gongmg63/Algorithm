package x16;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

//이중 우선순위 큐
public class p7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void func(int m) throws IOException{
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            switch (c) {
                case 'I':
                    if (!tree.containsKey(n))
                        tree.put(n, 1);
                    else
                        tree.put(n, tree.get(n) + 1);
                    break;
                case 'D':
                    if (!tree.isEmpty()) {
                        if (n == 1) {
                            if (tree.get(tree.lastKey()) == 1)
                                tree.remove(tree.lastKey());
                            else
                                tree.put(tree.lastKey(), tree.get(tree.lastKey()) - 1);
                        }
                        else {
                            if (tree.get(tree.firstKey()) == 1)
                                tree.remove(tree.firstKey());
                            else
                                tree.put(tree.firstKey(), tree.get(tree.firstKey()) - 1);
                        }
                    }
                    break;
            }
        }
        if (tree.isEmpty())
            bw.write("EMPTY\n");
        else {
            bw.write(tree.lastKey() + " " + tree.firstKey() + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            int m = Integer.parseInt(br.readLine());
            func(m);
        }

        br.close();
        bw.close();
    }
}
