package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private static final int NUMBER_SIZE = 3;

    private final List<Integer> baseballNumbers;

    public BaseballNumber(List<Integer> baseballNumbers) {
        validateNullOrEmpty(baseballNumbers);
        validateZeroNumber(baseballNumbers);
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateNullOrEmpty(List<Integer> baseballNumbers) {
        if (baseballNumbers == null || baseballNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] baseballNumbers 가 빈 값 입니다.");
        }
    }

    private void validateZeroNumber(List<Integer> baseballNumbers) {
        if (baseballNumbers.contains(0)) {
            throw new IllegalArgumentException("[ERROR] 0은 baseballNumber 가 아닙니다.");
        }
    }

    private void validateSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 3자리 수가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> baseballNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(baseballNumbers);
        if (nonDuplicateNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 입력할 수 없습니다.");
        }
    }

    public BaseballResultVO matchBaseballNumber(BaseballNumber otherNumbers) {
        int strikeCount = getStrikeCount(otherNumbers);
        int ballCount = getBallCount(otherNumbers);
        return new BaseballResultVO(strikeCount, ballCount);
    }

    private int getBallCount(BaseballNumber otherNumbers) {
        List<Integer> copyNumbers = new ArrayList<>(baseballNumbers);
        copyNumbers.retainAll(otherNumbers.baseballNumbers);
        return copyNumbers.size() - getStrikeCount(otherNumbers);
    }

    private int getStrikeCount(BaseballNumber otherNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_SIZE; ++i) {
            strikeCount += baseballNumbers.get(i).equals(otherNumbers.baseballNumbers.get(i)) ? 1 : 0;
        }
        return strikeCount;
    }
}