package baseball.view;

import baseball.common.MessageType;
import baseball.domain.BaseballNumber;
import baseball.util.BaseballUtil;
import nextstep.utils.Console;

import java.util.List;

public class InputView {
    private static final String RESTART_NUM = "1";
    private static final String EXIT_NUM = "2";

    public static BaseballNumber input() {
        System.out.print(MessageType.INPUT_BASEBALL_NUMBER.getMessage());
        try {
            List<Integer> inputNumbers = BaseballUtil.stringNumbersToList(Console.readLine());
            return new BaseballNumber(inputNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return input();
        }
    }

    public static boolean restartInput() {
        System.out.println(MessageType.INPUT_RESTART_NUMBER.getMessage());
        String input = Console.readLine();
        if (!(RESTART_NUM.equals(input) || EXIT_NUM.equals(input))) {
            System.out.println(MessageType.ERROR_RESTART_NUMBER.getMessage());
            return restartInput();
        }
        return RESTART_NUM.equals(input);
    }
}
