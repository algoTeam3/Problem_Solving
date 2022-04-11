
import java.util.ArrayList;

class chan {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int a = 0, b = 0, c = 0;
        int onelen = answers.length / one.length + 1;
        int twolen = answers.length / two.length + 1;
        int threelen = answers.length / three.length + 1;
        int max = 0, ans = 0;
        
        for(int i = 0; i < onelen; i++) {
            for(int j = 0; j < one.length; j++) {
                if(answers.length <= (j + (one.length * i)))
                    break;
                if(answers[(j + (one.length * i))] == one[j]) 
                    a += 1; 
            }
        }
        
        for(int i = 0; i < twolen; i++) {
            for(int j = 0; j < two.length; j++) {
                if(answers.length <= (j + (two.length * i)))
                    break;
                if(answers[(j + (two.length * i))] == two[j]) 
                    b += 1; 
            }
        }
        
        for(int i = 0; i < threelen; i++) {
            for(int j = 0; j < three.length; j++) {
                if(answers.length <= (j + (three.length * i)))
                    break;
                if(answers[(j + (three.length * i))] == three[j]) 
                    c += 1; 
            }
        }
        max = a > b ? (a > c ? a : c) : (b > c ? b : c);
        ArrayList<Integer> listans = new ArrayList<>();
        
        if(max == a)
            listans.add(1);
        if(max == b)
            listans.add(2);
        if(max == c)
            listans.add(3);
        
        answer = new int[listans.size()];
        for(Integer i : listans)
            answer[ans++] = i;
        return answer;
    }
}