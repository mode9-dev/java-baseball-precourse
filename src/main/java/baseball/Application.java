package baseball;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static boolean trySingleGame(GameBrokerController controller) {
        GameConsoleView.printInputRequired();
        String input = readLine();
        Result[] result = controller.run(input);
        GameConsoleView.printInputResult(result);
        boolean willContinue = false;

        boolean allStrikes = Arrays.stream(result).allMatch(x -> x == Result.STRIKE);
        if (allStrikes) {
            GameConsoleView.printSuccessMessage();
            GameConsoleView.printContinueAskInput();
            String continueOption = readLine();
            willContinue = controller.willContinue(continueOption);
        }
        if (willContinue) {
            GameBotModel.getInstance().initialize();
        }
        return !allStrikes || willContinue;
    }
    public static void main(String[] args) {
        GameBrokerController controller = new GameBrokerController();
        boolean onGaming = true;

        while (onGaming) {
            onGaming = trySingleGame(controller);
        }
        GameConsoleView.printGameFinished();
    }
}
