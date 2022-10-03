package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class GameBotModel {
    private static HashSet<Integer> answer;

    public HashSet<Integer> getAnswer() {
        return answer;
    }

    public static void setAnswer(HashSet<Integer> answer) {
        GameBotModel.answer = answer;
    }

    private int generateUniqueNumber() {
        /*
        @param container 이 해시셋에 없는 정수 값을 생성합니다.

        @return 해시셋에 포함되지 않으면서 1~9 범위의 정수를 반환합니다.
         */
        int num = Randoms.pickNumberInRange(1, 9);
        while (answer.contains(num)) {
            num = Randoms.pickNumberInRange(1, 9);
        }
        return num;
    }

    public void generateRandomDistinctAnswer() {
        /*
        1~9 범위의 서로 다른 정수 3개를 포함하는 배열을 반환합니다.

        @return HashSet<Integer>(3) 호출마다 항상 랜덤한 원소로 구성됩니다.
         */

        HashSet<Integer> newSet = new HashSet<>(3);

        newSet.add(this.generateUniqueNumber());
        newSet.add(this.generateUniqueNumber());
        newSet.add(this.generateUniqueNumber());
        setAnswer(newSet);
    }
}
