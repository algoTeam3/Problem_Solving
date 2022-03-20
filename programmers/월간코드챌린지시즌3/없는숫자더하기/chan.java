class chan {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] isExist = new boolean[10];
        
        for (int i = 0; i < numbers.length; i++) {
            isExist[numbers[i]] = true;
        }
        
        for (int i = 0; i < isExist.length; i++) {
            if (!isExist[i]) answer += i;
        }
        
        return answer;
    }
}
