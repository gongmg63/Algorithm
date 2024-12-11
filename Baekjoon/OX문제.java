import java.util.Scanner;

public class OX문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] ox = new String[num];
        int[] oxscore = new int[num];
        int score = 0;
        for(int i = 0; i < num; i++){
            ox[i] = sc.next();
        }
        for(int i = 0; i < ox.length; i++){
            for(int j = 0; j < ox[i].length(); j++){
                if(ox[i].charAt(j)=='O'){
                    score++;
                    oxscore[i] += score;
                }
                else{
                    score = 0;
                }
            }
            score = 0;
        }
        for(int i = 0 ; i < oxscore.length; i++){
            System.out.println(oxscore[i]);
        }
        sc.close();
    }
}