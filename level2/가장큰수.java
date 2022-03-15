package level2;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] stringnum = new String[numbers.length];
        String temp = "";
        for(int i = 0; i < numbers.length; i++){
            stringnum[i] = String.valueOf(numbers[i]);
        }
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length-i-1; j++){
                if(stringnum[j].charAt(0) > stringnum[j+1].charAt(0)){
                    temp = stringnum[j];
                    stringnum[j] = stringnum[j+1];
                    stringnum[j+1] = temp;
                }
                else if(stringnum[j].charAt(0) == stringnum[j+1].charAt(0)){
                    if(stringnum[j].length() <= stringnum[j+1].length()){
                        temp = stringnum[j];
                        while(temp.length() != stringnum[j+1].length()){
                            temp += stringnum[j].charAt(0); 
                        }
                        if(Integer.parseInt(temp) > Integer.parseInt(stringnum[j+1])){
                            temp = stringnum[j];
                            stringnum[j] = stringnum[j+1];
                            stringnum[j+1] = temp;
                        }
                        else if(Integer.parseInt(temp) == Integer.parseInt(stringnum[j+1])){
                            if(Integer.parseInt(stringnum[j]) > Integer.parseInt(stringnum[j+1])){
                                temp = stringnum[j];
                                stringnum[j] = stringnum[j+1];
                                stringnum[j+1] = temp;
                            }
                        }
                    }
                    else if(stringnum[j].length() > stringnum[j+1].length()){
                        temp = stringnum[j+1];
                        while(stringnum[j].length() != temp.length()){
                            temp += stringnum[j].charAt(0);
                        }
                        if(Integer.parseInt(stringnum[j]) > Integer.parseInt(temp)){
                            temp = stringnum[j];
                            stringnum[j] = stringnum[j+1];
                            stringnum[j+1] = temp;
                        }
                        else if(Integer.parseInt(temp) == Integer.parseInt(stringnum[j])){
                            if(Integer.parseInt(stringnum[j]) > Integer.parseInt(stringnum[j+1])){
                                temp = stringnum[j];
                                stringnum[j] = stringnum[j+1];
                                stringnum[j+1] = temp;
                            }   
                        }
                    }
                }
            }
        }
        if(stringnum[stringnum.length-1].equals("0")){
            return "0";
        }
        for(int i = stringnum.length-1; i >= 0; i--){
            answer.append(stringnum[i]);
        }
        return String.valueOf(answer);
    }
}

public class 가장큰수 {
    
}
