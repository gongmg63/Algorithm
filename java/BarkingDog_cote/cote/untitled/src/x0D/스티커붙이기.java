package x0D;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커붙이기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] laptop = new boolean[40][40];
    static int n, m;

    static void setStartPosition(int kn, int km, boolean[][] paint) throws IOException {
        for (int k = 0; k < 4; ++k) {
            for (int i = 0; i + kn <= n; ++i) {
                for (int j = 0; j + km <= m; ++j) {
                    if (fillLaptop(kn, km, paint, i, j))
                        return ;
                }
            }
            paint = cyclePaint(kn, km, paint);

            int tmp = kn;
            kn = km;
            km = tmp;
        }
    }

    static boolean fillLaptop(int kn, int km, boolean[][] paint, int startN, int startM) {
        boolean[][] tmp = new boolean[40][40];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (laptop[i][j])
                    tmp[i][j] = true;
            }
        }

        for (int i = 0; i < kn; i++) {
            for (int j = 0; j < km; ++j) {
                if (paint[i][j]) {
                    if (tmp[startN + i][startM + j])
                        return false;
                    tmp[startN + i][startM + j] = true;
                }
            }
        }
        laptop = tmp;
        return true;
    }

    static boolean[][] cyclePaint(int kn, int km, boolean[][] paint) throws IOException{
        boolean[][] tmpPaint = new boolean[40][40];

        for (int i = 0; i < kn; ++i)
            for (int j = 0; j < km; ++j)
                tmpPaint[j][kn - 1 - i] = paint[i][j];
        return tmpPaint;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int kn = Integer.parseInt(st.nextToken());
            int km = Integer.parseInt(st.nextToken());

            boolean[][] paint = new boolean[40][40];
            for (int j = 0; j < kn; ++j) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < km; ++l)
                    if (st.nextToken().equals("1"))
                        paint[j][l] = true;
            }
            setStartPosition(kn, km, paint);

        }

        int ret = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (laptop[i][j])
                    ++ret;
            }
        }
        bw.write(ret + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
