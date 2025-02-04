import java.util.Scanner;

public class 알파벳개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alp = new int[26];
        String word = sc.nextLine();
        for(int i = 0; i < word.length(); i++){
            alp[word.charAt(i)-'a']++;
        }
        for(int i = 0; i < alp.length; i++){
            System.out.print(alp[i] + " ");
        }
    }
}