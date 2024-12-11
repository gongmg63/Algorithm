package x16;

import java.io.*;
import java.util.*;

//보석 도둑
public class p1202 {
    static class Pair implements Comparable<Pair>{
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(pair.x, this.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Pair> jewels = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.add(new Pair(value, weight));
        }
        jewels.sort(Pair::compareTo);

        TreeMap<Integer, Integer> bags = new TreeMap<>();
        for (int i = 0; i < k; ++i) {
            int bag = Integer.parseInt(br.readLine());

            if (!bags.containsKey(bag))
                bags.put(bag, 1);
            else
                bags.put(bag, bags.get(bag) + 1);
        }

        long ret = 0;
        for (Pair pair : jewels) {
            if (bags.isEmpty())
                break;
            Integer weight = bags.ceilingKey(pair.y);
            if (weight == null)
                continue;
            ret += pair.x;
            if (bags.get(weight) == 1)
                bags.remove(weight);
            else
                bags.put(weight, bags.get(weight) - 1);
        }
        bw.write(ret + "\n");

        br.close();
        bw.close();
    }
}
