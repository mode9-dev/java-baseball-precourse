package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBotModelTest {

    private HashSet<Integer> intArrToHashSet(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toCollection(HashSet::new));
    }

    @Test
    void 랜덤_정답_생성() {
        HashSet<Integer> newAnswer = this.intArrToHashSet(BaseballAnswer.generateRandomDistinctIntArray());
        assertThat(newAnswer)
                .hasSize(Config.GAME_COUNT)
                .satisfies(answer -> {
                    for (int num : answer) {
                        assertThat(num)
                                .isNotNull()
                                .isPositive()
                                .isBetween(Config.MIN_NUM, Config.MAX_NUM);

                    }
                });
    }

    @Test
    void GameBot_calcResult() {
        BaseballAnswer answer = new BaseballAnswer();
        answer.setAnswer(new int[]{2, 3, 4});
        answer.setMemo(new boolean[]{false, false, true, true, true, false, false, false, false});

        int[][] inputs = {{2,1,4}, {3,5,2}, {4,2,3}, {2,3,4}};
        Result[][] expResults = {
                {Result.STRIKE, Result.NOTHING, Result.STRIKE},
                {Result.BALL, Result.NOTHING, Result.BALL},
                {Result.BALL, Result.BALL, Result.BALL},
                {Result.STRIKE, Result.STRIKE, Result.STRIKE}
        };
        for (int i = 0; i < 4; i++) {
            Result[] result = answer.calcResult(inputs[i]);
            assertThat(result).isEqualTo(expResults[i]);
        }
    }
}
