package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.util.BaseballUtil;
import nextstep.utils.Console;

import java.util.List;

public class InputView {
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
}
