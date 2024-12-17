package level2;

import java.util.*;

public class 호텔대실 {
    static class Pair implements Comparable<Pair> {
        public int start;
        public int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(start, pair.start);
        }
    }

    public int solution(String[][] book_time) {
        int answer = 0;

        ArrayList<Pair> list = new ArrayList<>();
        for (String[] strings : book_time) {
            StringBuilder start = new StringBuilder(strings[0]);
            start.deleteCharAt(2);
            StringBuilder end = new StringBuilder(strings[1]);
            end.deleteCharAt(2);
            list.add(new Pair(Integer.parseInt(start.toString()), Integer.parseInt(end.toString())));
        }
        list.sort(Pair::compareTo);

        ArrayList<Integer> room = new ArrayList<>();
        for (Pair p : list) {
            int endTime = (p.end + 10) % 100 >= 60 ? p.end + 50 : p.end + 10;
            if (room.isEmpty())
                room.add(endTime);
            else {
                Collections.sort(room);
                boolean check = false;

                for (int i = 0; i < room.size(); ++i) {
                    if (room.get(i) <= p.start) {
                        room.set(i, endTime);
                        check = true;
                        break;
                    }
                }
                if (!check)
                    room.add(endTime);
            }
        }
        return room.size();
    }
}
