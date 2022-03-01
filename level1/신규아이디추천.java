package level1;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder(new_id);
        for(int i = 0; i < sb.length(); i++){
            if(!Character.isLetterOrDigit(sb.charAt(i))&&sb.charAt(i)!='-'&&sb.charAt(i)!='.'&&sb.charAt(i)!='_'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        for(int i = 0; i < sb.length()-1; i++){
            if(sb.charAt(i)=='.' && sb.charAt(i+1)=='.'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        if(sb.charAt(0)=='.')
            sb.deleteCharAt(0);
        if(sb.charAt(sb.length()-1)=='.')
            sb.deleteCharAt(sb.length()-1);
        if(sb.length() > 16){
            new_id = sb.substring(0, 15);
            sb.setLength(0);
            for(int i = 0; i < new_id.length(); i++)
                sb.append(new_id.charAt(i));
        }
        if(sb.length()==0)
            sb.append("a");
        if(sb.length() < 3){
            for(int i = sb.length(); i < 3; i++){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        return sb.toString();
    }
}