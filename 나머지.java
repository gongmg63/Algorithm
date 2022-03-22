import java.util.Arrays;
import java.util.Scanner;

public class 나머지{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rem = new int[10];
        int num = 1;
        for(int i = 0;i < 10; i++)
            rem[i] = sc.nextInt()%42;
        Arrays.sort(rem);
        for(int i = 0; i < 9; i++){
            if(rem[i] != rem[i+1])
                num++;
        }
        System.out.println(num);
    }
}