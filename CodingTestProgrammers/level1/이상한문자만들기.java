class Solution {
    public String solution(String s) {
        String answer = "";
        String sl[] = s.split(" ",-1);
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i<sl.length;i++){
            for(int j=0;j<sl[i].length();j++){
                if(j%2==1)
                    sb.append(String.valueOf(Character.toLowerCase(sl[i].charAt(j))));
                else
                    sb.append(String.valueOf(Character.toUpperCase(sl[i].charAt(j))));
                    
            }
            if(i<sl.length-1)
                sb.append(" ");
        }
        
        answer = String.valueOf(sb);
        
        return answer;
    }
}