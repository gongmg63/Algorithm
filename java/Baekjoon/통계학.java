import java.util.Arrays;
import java.util.Scanner;

public class 통계학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];
        int average = 0;
        for(int i = 0; i < n; i++){
            number[i] = sc.nextInt();
            average += number[i];
        }
        Arrays.sort(number);
        average = Math.round((float)average/n);
        int mid = number[n/2];
        int range = number[n-1] - number[0];
        int max1 = 0;
        int max2 = 0;
        int max = number[0];
        for(int i = 0; i < n-1; i++){
            if(number[i] == number[i+1]){
                max1++;
            }
            else if(number[i] != number[i+1]){
                if(max1 >= max2){
                    max2 = max1;
                }
                max1 = 0;
            }
        }
        int nu = 0;
        max1 = 0;
        for(int i = 0; i < n - 1; i++){
            if(number[i] == number[i+1]){
                max1++;
            }
            else if(number[i]!=number[i+1])
                max1 = 0;
            if(max1 == max2 ){
                max = number[i];
                nu++;
            }
            if(nu==2)
                break;
        }
        System.out.println(average + "\n" + mid + "\n" + max + "\n" + range);
        sc.close();
    }
}