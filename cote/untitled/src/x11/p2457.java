package x11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공주님의 정원
public class p2457 {

    static class Flower implements Comparable<Flower> {
        public int start;
        public int end;

        Flower(int startMonth, int startDay, int endMonth, int endDay) {
            this.start = startMonth * 100 + startDay;
            if (this.start < 301)
                this.start = 301;

            this.end = endMonth * 100 + endDay;
            if (this.end > 1201)
                this.end = 1201;
        }

        @Override
        public int compareTo(Flower flower) {
            if (this.start > flower.start)
                return 1;
            else if (this.start == flower.start)
                return 0;
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        // 3/1 ~ 11/30 을 포함, 중간이 빌 경우 0을 반환
        // 반드시 포함되어야 하는 꽃 - 03/01 이전에 피면서 가장 늦게 지는 꽃
        // 이를 찾기 위해 시작일을 기준으로 정렬, 그 뒤 이전 꽃 지는 날 + 1 이전에 피면서 가장 늦게 지는 꽃을 찾으면 됨
        // 지는 날은 꽃이 피지 않은걸로 간주함

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(startMonth, startDay, endMonth, endDay);
        }

        Arrays.sort(flowers);

        //첫 번째 꽃 고르기 ( 301로 시작하는 꽃 )
        Flower present = flowers[0];
        if (present.start != 301) {
            bw.write("0\n");

            bw.close();
            br.close();
            return ;
        }
        for (int i = 1; i < n; ++i) {
            if (flowers[i].start == 301 && flowers[i].end > present.end)
                present = flowers[i];
        }

        int count = 1;
        
        // 다음 꽃 고르기
        int end = present.end;
        for (int i = 0; i < n; ++i) {
            if (flowers[i].start < end + 1) { // 현재 꽃이 지는 날 보다 안쪽인 꽃들을 확인
                if (flowers[i].end > present.end) { // 지는 날이 가장 늦는 꽃 찾기
                    present = flowers[i];
                    if (present.end == 1201) {
                        ++count;
                        end = present.end;
                        break;
                    }
                }
            }
            else { // 현재 꽃 바꿔주기
                if (present.end == end) // 현재 꽃이 바뀌지 않았으면 중간에 비는 날이 있다는 의미
                    break;
                ++count;
                end = present.end;
                --i; //이번 인덱스에 있는 꽃 역시 다시한번 확인 해봐야 함
            }
        }
        if (end == 1201)
            bw.write(count + "\n");
        else
            bw.write("0\n");

        bw.close();
        br.close();
    }
}
