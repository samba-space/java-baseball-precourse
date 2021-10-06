package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResultVO;
import baseball.view.InputView;
import baseball.view.OutputView;
import nextstep.utils.Randoms;

import java.util.*;

public class BaseballService {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private static final int NUMBER_SIZE = 3;

    public void play() {
        BaseballNumber computerNumbers = new BaseballNumber(createNonDuplicateNumbers());
        BaseballResultVO result;
        do {
            BaseballNumber userNumbers = InputView.input();
            result = computerNumbers.matchBaseballNumber(userNumbers);
            OutputView.output(result);
        } while (!result.isFinish());
    }

    public boolean isRestart() {
        return InputView.restartInput();
    }

    public List<Integer> createNonDuplicateNumbers() {
        Set<Integer> nonDuplicateNumbers = new LinkedHashSet<>();
        while (nonDuplicateNumbers.size() < NUMBER_SIZE) {
            nonDuplicateNumbers.add(Randoms.pickNumberInRange(RANGE_START, RANGE_END));
        }
        return new ArrayList<>(nonDuplicateNumbers);
    }
}
