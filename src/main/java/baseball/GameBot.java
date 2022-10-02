package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class GameBot {

    private int generateUniqueNumberNotIn(HashSet<Integer> container) {
        /*
        @param container 이 해시셋에 없는 정수 값을 생성합니다.

        @return 해시셋에 포함되지 않으면서 1~9 범위의 정수를 반환합니다.
         */
        int num = Randoms.pickNumberInRange(1, 9);
        while (container.contains(num)) {
            num = Randoms.pickNumberInRange(1, 9);
        }
        return num;
    }

    public HashSet<Integer> generateRandomDistinctAnswer() {
        /*
        1~9 범위의 서로 다른 정수 3개를 포함하는 배열을 반환합니다.

        @return HashSet<Integer>(3) 호출마다 항상 랜덤한 원소로 구성됩니다.
         */

        HashSet<Integer> answer = new HashSet<>(3);

        answer.add(this.generateUniqueNumberNotIn(answer));
        answer.add(this.generateUniqueNumberNotIn(answer));
        answer.add(this.generateUniqueNumberNotIn(answer));
        return answer;
    }
}
