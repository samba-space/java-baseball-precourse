package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.util.BaseballUtil;
import nextstep.utils.Console;

import java.util.List;

public class InputView {
    private static final String RESTART_NUM = "1";
    private static final String EXIT_NUM = "2";

    public static BaseballNumber input() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            List<Integer> inputNumbers = BaseballUtil.stringNumbersToList(Console.readLine());
            return new BaseballNumber(inputNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return input();
        }
    }

    public static boolean restartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!(RESTART_NUM.equals(input) || EXIT_NUM.equals(input))) {
            System.out.println("[ERROR] 1 또는 2가 아닙니다.");
            return restartInput();
        }
        return RESTART_NUM.equals(input);
    }
}
