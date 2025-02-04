class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        for(int i = 0;i<n;i++) {
        	map1[i] = String.format("%s",Integer.toBinaryString(arr1[i]).replace(" ","0"));
        	map2[i] = String.format("%s",Integer.toBinaryString(arr2[i]).replace(" ","0"));
        }
		for(int i = 0;i<n;i++) {
            while(map1[i].length()<n) { 
                String tmp = map1[i];
                map1[i] = "0" + tmp; 
            } 
            while(map2[i].length()<n) { 
                String tmp2 = map2[i];
                map2[i] = "0" + tmp2; 
            } 
        }
        
        for(int i = 0;i<n;i++) {
            answer[i] = "";
        	for(int j=0;j<n;j++) {
        		if(map1[i].charAt(j)=='1' || map2[i].charAt(j)=='1') 
        			answer[i] += '#';
        		else if(map1[i].charAt(j)=='0' && map2[i].charAt(j)=='0')
        			answer[i] += ' ';
        	}
        }
        return answer;
    }
}