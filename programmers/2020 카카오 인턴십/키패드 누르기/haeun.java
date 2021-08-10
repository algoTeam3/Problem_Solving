package com.ssafy.solution;

public class Programmers_lv1_키패드누르기 {
    public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));

	}
	
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        // 왼손, 오른손의 현재 위치
        int left = 10;
        int right = 12;
        // 왼손, 오른손 위치 비교
        int distL = 0;
        int distR = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) numbers[i] = 11;
            // 왼쪽 열의 숫자일 때
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            }
            // 오른쪽 열의 숫자일 때
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            }
            // 가운데 열의 숫자일 때
            else {
                distL = left == 2 || left == 5 || left == 8 || left == 11 ? Math.abs(numbers[i] - left) / 3 : Math.abs(numbers[i] - 1 - left) / 3 + 1;
                distR = right == 2 || right == 5 || right == 8 || right == 11 ? Math.abs(numbers[i] - right) / 3 : Math.abs(numbers[i] + 1 - right) / 3 + 1;
                // 만일 왼손 거리와 오른손 거리가 같다면
                if (distL == distR) {
                    // 만일 왼손잡이라면
                    if (hand == "left") {
                        answer += 'L';
                        left = numbers[i];
                    }
                    // 만일 오른손잡이라면
                    else {
                        answer += 'R';
                        right = numbers[i];
                    }
                }

                // 만일 왼손이 오른손보다 가깝다면
                else if (distL < distR) {
                    answer += 'L';
                    left = numbers[i];
                }
                // 만일 오른손이 왼손보다 가깝다면
                else {
                    answer += 'R';
                    right = numbers[i];
                }
            }
        }
        return answer;
    }
}
