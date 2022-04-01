import java.util.*;
import java.io.*;

class chan {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] students = new boolean[n + 1];    // 학생의 체육복 소유 여부
        boolean[] canBorrow = new boolean[n + 1];   // 여분의 체육복을 가진 학생
        
        Arrays.fill(students, true);
        
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] = false;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            canBorrow[reserve[i]] = true;
        }
        
        // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        for (int i = 1; i < students.length; i++) {
            if (!students[i] && canBorrow[i]) {
                students[i] = true;
                canBorrow[i] = false;
            }
        }
        
        for (int i = 1; i < students.length; i++) {
            if (!students[i]) {     // 체육복을 잃어버린 학생일 때
                // 앞 사람이 여분이 있을 때
                if (canBorrow[i - 1]) {
                    students[i] = true;
                    canBorrow[i - 1] = false;
                    continue;
                } 
                // 뒷 사람이 여분이 있을 때
                if (i < n && canBorrow[i + 1]) {
                    students[i] = true;
                    canBorrow[i + 1] = false;
                }
            }
        }
        
        for (int i = 1; i < students.length; i++) {
            if (students[i]) answer++;
        }
        
        return answer;
    }
}