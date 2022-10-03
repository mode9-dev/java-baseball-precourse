package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBotModelTest {

    @Test
    void 랜덤_정답_생성() {
        GameBotModel bot = new GameBotModel();
        bot.generateRandomDistinctAnswer();
        int ANSWER_SIZE = 3;

        assertThat(bot.getAnswer())
                .satisfies(answer -> {
                   assertThat(answer.size()).isEqualTo(ANSWER_SIZE);
                    for (int num : answer) {
                        assertThat(num)
                                .isNotNull()
                                .isPositive()
                                .isBetween(1, 9);

                    }
                });
    }
}
