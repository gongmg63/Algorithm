package x18;

import java.io.*;
import java.util.*;

// 그래프
public class p1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, v;
    static ArrayList<Set<Integer>> listGraph = new ArrayList<>();
    static boolean[] vis;

    static void dfs(int cur) throws IOException {
        if (vis[cur])
            return;
        bw.write(cur + " ");
        vis[cur] = true;
        for (int i : listGraph.get(cur)) {
            if (vis[i])
                continue;
            dfs(i);
        }
    }

    static void bfs() throws IOException {
        Arrays.fill(vis, false);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
        vis[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");
            for (int i : listGraph.get(cur)) {
                if (vis[i])
                    continue;
                vis[i] = true;
                q.offer(i);
            }
        }
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        vis = new boolean[n + 1];
        for (int i = 0; i < n + 1; ++i)
            listGraph.add(new TreeSet<>());

        for (int i  = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            listGraph.get(node1).add(node2);
            listGraph.get(node2).add(node1);
        }

        dfs(v);
        bw.write("\n");
        bfs();

        bw.close();
        br.close();
    }
}
