package level2;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        for(int i = 0; i < name.length(); i++){
            answer+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i) + 1);
            int index = i+1;
            while(index < name.length() && name.charAt(index)=='A'){
                index++;
            }
            
            move = Math.min(move,Math.min(i+i+name.length()-index,(name.length()-index)*2+i));
            /*i+i+name.length()-index 는 A가 반복되는 구간인 i~index는 지나가지 않고 앞으로 갔다가
            뒤로 가는 방법이다(name.lengh()-index는 뒤에서 A가 아닌 index까지의 거리를 나타냄)
            (name.length()-index)*2+i 에서 (name.length()-index)*2는 
            뒤로 갔다가 앞으로 가는 걸 나타내며 i+i와 의미가 같다. 
            마지막에 더해주는 i는 마찬가지로 name.lengh()-index 와 의미가 같다. 
            */
        }
        return answer+move;
    }
}
public class 조이스틱 {
    
}
