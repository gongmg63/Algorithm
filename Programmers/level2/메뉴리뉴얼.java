package level2;

import java.util.*;

public class 메뉴리뉴얼 {
    ArrayList<String> ans = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    int max;

    void makeAllCourse(String[] orders, int num) {
        max = 0;
        map.clear();
        for (String order : orders) {
            if (order.length() < num) continue;

            makeCourse(order, num, new StringBuilder(), 0);

        }
        if (max == 1)
            return ;

        for (String course : map.keySet()) {
            if (map.get(course) == max)
                ans.add(course);
        }
    }

    void makeCourse(String order, int num, StringBuilder course, int index) {
        if (course.length() == num) {
            if (map.containsKey(course.toString()))
                map.compute(course.toString(), (key, value) -> value + 1);
            else
                map.put(course.toString(), 1);
            if (max < map.get(course.toString()))
                max = map.get(course.toString());
            return ;
        }
        for (int i = index; i < order.length(); ++i) {
            course.append(order.charAt(i));
            makeCourse(order, num, course, i + 1);
            course.deleteCharAt(course.length() - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        for (int i = 0; i < orders.length; ++i) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            orders[i] = new String(tmp);
        }
        for (int i : course)
            makeAllCourse(orders, i);

        answer = new String[ans.size()];
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); ++i) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
