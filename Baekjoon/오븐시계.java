import java.util.Scanner;

public class 오븐시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();

        int remin = min + time;
        if(remin >= 60){
            int phour = remin/60;
            remin = remin%60;
            hour += phour;
            if(hour >= 24){
                hour = hour%24;
            }
        }
        System.out.println(hour + " " + remin);
    }
}
