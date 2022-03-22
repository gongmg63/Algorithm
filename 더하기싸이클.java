import java.util.*;

public class 더하기싸이클{
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int num = sc.nextInt();
    	int sum = 0;
    	int tmp = num;
    	while(tmp!=num || sum==0){
    		if(num < 10) {
    			num = num*10 + num;
    			sum++;
    		}
    		else {
    			int pr = num/10 + num%10;
    			num = num%10*10 + pr%10;
    			sum++;
    		}
    	}
    	System.out.println(sum);
    }
}