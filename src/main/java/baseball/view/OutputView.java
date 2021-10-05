package baseball.view;

import baseball.domain.ResultVO;

public class OutputView {
    public static void output(ResultVO result) {
        int strike = result.getStrike();
        int ball = result.getBall();
        if (strike > 0) {
            System.out.printf("%d스트라이크 ", strike);
        }
        if (ball > 0) {
            System.out.printf("%d볼", ball);
        }
        printOrderCase(result);
    }

    private static void printOrderCase(ResultVO result) {
        if (result.isFinish()) {
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
        if (result.isNoting()) {
            System.out.println("낫싱");
        }
    }
}