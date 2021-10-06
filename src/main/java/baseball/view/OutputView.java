package baseball.view;

import baseball.common.MessageType;
import baseball.domain.BaseballResultVO;

public class OutputView {
    private static final String RESULT_FORMAT = "%d스트라이크 %d볼";

    public static void output(BaseballResultVO result) {
        System.out.println(getPrintFormat(result));
        if (result.isFinish()) {
            System.out.println(MessageType.RESULT_GAME_OVER.getMessage());
        }
    }

    private static String getPrintFormat(BaseballResultVO result) {
        String printFormat = String.format(RESULT_FORMAT, result.getStrike(), result.getBall());
        if (result.isNoting()) {
            return MessageType.RESULT_NOTING.getMessage();
        }
        if (result.isBoth()) {
            return printFormat;
        }
        return result.getStrike() > 0 ? printFormat.split(" ")[0] : printFormat.split(" ")[1];
    }
}