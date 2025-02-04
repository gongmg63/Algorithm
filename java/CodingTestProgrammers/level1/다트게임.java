import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = {0,0,0};
        int index = -1;
        for(int i = 0; i < dartResult.length(); i++) {
        	if(Character.isDigit(dartResult.charAt(i))) {
        		index++;
        		if(Character.isDigit(dartResult.charAt(i+1))) {
        			score[index] = 10;
        			i++;
        		}
        		else {
        			score[index] = Character.getNumericValue(dartResult.charAt(i));
        		}
        	}
        	else if(dartResult.charAt(i)=='D') {
        		score[index] *= score[index];
        	}
        	else if(dartResult.charAt(i)=='T') {
        		score[index] *= score[index]*score[index];
        	}
        	else if(dartResult.charAt(i)=='*') {
        		score[index] *= 2;
        		if (index > 0)
        			score[index-1] *=2;
        	}
        	else if(dartResult.charAt(i)=='#') {
        		score[index] *=-1;
        	}
        }
        return score[0]+score[1]+score[2];
    }
}