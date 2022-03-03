import java.util.*;
import java.io.*;

class chan {
    static int answer;
    static char[] friends= new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] selectFriends;
    static boolean[] isSelected;
    static int N = friends.length;
    public int solution(int n, String[] data) {
        answer = 0;

        selectFriends = new char[N];
        isSelected = new boolean[N + 1];

        // 1. 8개 중 8개를 뽑는 순열 구하기
        perm(0, n, data);
        
        return answer;
    }
    
    private static void perm(int cnt, int n, String[] data) {
        if (cnt == N) {
            // 2. 기저조건으로 data에 만족하면 cnt 올리기
            if (check(selectFriends, n, data)) {
            	answer++;
            }
            return ;
        }
        
        for (int i = 0; i < N; i++) {
        	
        	if (isSelected[i]) continue;
        	
        	selectFriends[cnt] = friends[i];
        	isSelected[i] = true;
        	
        	perm(cnt + 1, n, data);
        	isSelected[i] = false;
        	
        }
    }
    
    private static boolean check(char[] selectFriends, int n, String[] data) {

    	// char 배열을 하나의 문자열로 
    	String friendsString = "";
    	for (int j = 0; j < N; j++) {
    		friendsString += selectFriends[j];
    	}
    	
    	for (int i = 0; i < n; i++) {
    		
    		String condition = data[i];
            char a = condition.charAt(0);
            char b = condition.charAt(2);
            char f = condition.charAt(3);
            int space = condition.charAt(4) - '0';
            // a의 인덱스
            int indexA = friendsString.indexOf(a);
            // b의 인덱스
            int indexB = friendsString.indexOf(b);
            
            // return false로 바로 반환하지 않고, n번의 for문이 끝난 후 결과를 반환하면 시간초과
            switch(f) {
            case '=':
            	if(Math.abs(indexA - indexB) - 1 != space) return false;
            	break;
            case '<':
            	if(Math.abs(indexA - indexB) - 1 >= space) return false;
            	break;
            case '>':
            	if(Math.abs(indexA - indexB) - 1 <= space) return false;
            	break;
            }
            
    	}
    
        return true;
	}
}
