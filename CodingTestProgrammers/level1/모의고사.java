import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] first = new int[answers.length];
        int[] second = new int[answers.length];
        int[] third = new int[answers.length];
        for(int i=0;i<first.length; i++){
            if(i%5==0)
                first[i]=1;
            else if(i%5==1)
                first[i]=2;
            else if(i%5==2)
                first[i]=3;
            else if(i%5==3)
                first[i]=4;
            else
                first[i]=5; 
        }
        for(int i=0;i<second.length; i++){
            if(i%2==0)
                second[i]=2;
            else{
                if(i%8==1)
                    second[i]=1;
                else if(i%8==3)
                    second[i]=3;
                else if(i%8==5)
                    second[i]=4;
                else if(i%8==7)
                    second[i]=5;
            }
        }
        for(int i=0;i<third.length; i++){
            if(i%10==0 || i%10 == 1)
                third[i]=3;
            else if(i%10==2 || i%10==3)
                third[i]=1;
            else if(i%10==4 || i%10==5)
                third[i]=2;
            else if(i%10==6 || i%10==7)
                third[i]=4;
            else if(i%10==8 || i%10==9)
                third[i]=5;
        }
        int fa=0;
        int sa=0;
        int ta=0;
        for(int i=0; i < answers.length; i++){
            if(answers[i]==first[i])
                fa++;
            if(answers[i]==second[i])
                sa++;
            if(answers[i]==third[i])
                ta++;
        }
        if(fa>sa){
            if(fa>ta)
                answer.add(1);
            else if(fa==ta){
                answer.add(1);
                answer.add(3);
            }
            else
                answer.add(3);
        }
        else if(fa<sa){
            if(sa>ta)
                answer.add(2);
            else if(sa==ta){
                answer.add(2);
                answer.add(3);
            }
            else
                answer.add(3);
        }
        else{
            if(fa>ta){
                answer.add(1);
                answer.add(2);
            }
            else if(fa < ta)
                answer.add(3);
            else{
                answer.add(1);
                answer.add(2);
                answer.add(3);
            }
        }
        return answer;
    }
}