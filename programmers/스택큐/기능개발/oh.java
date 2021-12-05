import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class oh {
    public static void main(String[] args) {
        solution(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1}).stream().forEach(Object-> System.out.println(Object));
    }
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            int value=(100-progresses[i])%speeds[i]==0?(100-progresses[i])/speeds[i]:(100-progresses[i])/speeds[i]+1;
            que.add(value);
        }
        int count =1;
        ArrayList<Integer> answer = new ArrayList<>();
        int result =que.poll();
        while (!que.isEmpty()){
           if(que.peek()<=result){
               count++;
               que.poll();
           }
           else{
               answer.add(count);
               count=1;
               result=que.poll();
           }
       }
        answer.add(count);
        return answer;
    }
}
