import java.util.Arrays;
import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String room = sc.nextLine();
        int[] num = new int[10];
        for(int i = 0; i < room.length(); i++){
            num[room.charAt(i)-'0']++;
        }
        if(num[6] + num[9] % 2 != 0){
            num[6] = (num[6]+num[9]+1)/2;
            num[9] = num[6];
        }
        else{
            num[6] = (num[6] + num[9])/2;
            num[9] = num[6];
        }
        Arrays.sort(num);
        System.out.println(num[9]);
        sc.close();
    }
}