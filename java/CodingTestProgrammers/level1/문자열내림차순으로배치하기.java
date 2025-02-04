import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        StringBuffer answer = new StringBuffer();
        Arrays.sort(arr);
        for (int i = arr.length-1;i>=0;i--)
            answer.append(String.valueOf(arr[i]));
        return String.valueOf(answer);
    }
}