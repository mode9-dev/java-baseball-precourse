package baseball;

public class GameConsoleView {
    public static int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }

    public static int[] resultsToStrikeBallCountArray(Result[] results) {
        int[] resultArray = new int[2];
        for (int i = 0; i < results.length; i++) {
            resultArray[0] = boolToInt(results[i] == Result.BALL);
            resultArray[1] = boolToInt(results[i] == Result.STRIKE);
        }
        return resultArray;
    }

    public static void printInputRequired() {
        System.out.println("숫자를 입력해주세요: ");
    }

    public static int sum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static void printInputResult(Result[] results) {
        int[] countArray = resultsToStrikeBallCountArray(results);
        int ballCount = countArray[0];
        int strikeCount = countArray[1];
        if (sum(countArray) == 0) {
            System.out.println("낫싱");
            return;
        }
        String resultString = String.format("%1$d 볼 %2$d 스트라이크", ballCount, strikeCount).trim();
        System.out.printf(resultString);
    }

    public static void printSuccessMessage() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Config.GAME_COUNT);
    }

    public static void printContinueAskInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printGameFinished() {
        System.out.println("게임 종료");
    }
}
