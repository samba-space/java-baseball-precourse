package baseball.view;

import baseball.domain.BaseballResultVO;

public class OutputView {
    public static void output(BaseballResultVO result) {
        System.out.println(getPrintFormat(result));
        if (result.isFinish()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
    }

    private static String getPrintFormat(BaseballResultVO result) {
        String printFormat = String.format("%d스트라이크 %d볼", result.getStrike(), result.getBall());
        if (result.isNoting()) {
            return "낫싱";
        }
        if (result.isBoth()) {
            return printFormat;
        }
        return result.getStrike() > 0 ? printFormat.split(" ")[0] : printFormat.split(" ")[1];
    }
}