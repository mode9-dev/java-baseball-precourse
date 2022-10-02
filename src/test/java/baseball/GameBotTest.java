package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBotTest {

    @Test
    void 랜덤_정답_생성() {
        GameBot bot = new GameBot();
        HashSet<Integer> answer = bot.generateRandomDistinctAnswer();
        int ANSWER_SIZE = 3;

        assertThat(answer)
                .satisfies(arrAnswer -> {
                   assertThat(arrAnswer.size()).isEqualTo(ANSWER_SIZE);
                    for (int num : arrAnswer) {
                        assertThat(num)
                                .isNotNull()
                                .isPositive()
                                .isBetween(1, 9);

                    }
                });
    }
}
