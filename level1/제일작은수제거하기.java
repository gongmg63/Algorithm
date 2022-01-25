class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else {
            int[] answer = new int[arr.length-1];
            int x = arr[0];
            int index = 0;
            for(int i = 0;i<arr.length;i++){
                if(x > arr[i]){
                    x = arr[i];
                    index = i;
                }
            }
            for(int i = 0;i < answer.length; i++){
                if (index == arr.length-1)
                    answer[i] = arr[i];
                else {
                    if (index <= i)
                        answer[i] = arr[i+1];
                    else
                        answer[i] = arr[i];
                }
            }
            return answer;
        }
    }
}