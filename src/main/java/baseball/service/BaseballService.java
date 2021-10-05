package baseball.service;

import nextstep.utils.Randoms;

import java.util.*;

public class BaseballService {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private static final int NUMBER_SIZE = 3;

    public List<Integer> createNonDuplicateNumbers() {
        Set<Integer> nonDuplicateNumbers = new HashSet<>();
        while (nonDuplicateNumbers.size() < NUMBER_SIZE) {
            nonDuplicateNumbers.add(Randoms.pickNumberInRange(RANGE_START, RANGE_END));
        }
        return new ArrayList<>(nonDuplicateNumbers);
    }
}
