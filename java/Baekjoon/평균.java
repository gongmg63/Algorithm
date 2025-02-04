import java.util.Scanner;

public class 평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sub = sc.nextInt();
        double[] score = new double[sub];
        double  max = 0;
        double answer = 0;
        for(int i = 0; i < sub; i++)
            score[i] = sc.nextInt();
        for(int i = 0; i < score.length; i++){
            if (max < score[i])
                max = score[i];
        }
        for(int i = 0; i < score.length; i++){
            score[i] = score[i]/max*100;
            answer += score[i];
        }
        System.out.println(answer/sub);
        sc.close();
    }
}
