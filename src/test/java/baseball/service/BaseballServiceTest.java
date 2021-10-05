package baseball.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballServiceTest {

    private static BaseballService baseballService;

    @BeforeAll
    static void setUp() {
        baseballService = new BaseballService();
    }

    @Test
    void 중복없는_3자리수_생성() {
        //given
        int numberSize = 3;

        //when
        List<Integer> randomNumbers = baseballService.createNonDuplicateNumbers();
        Set<Integer> nonDuplicateNumbers = new HashSet<>(randomNumbers);

        //then
        assertThat(nonDuplicateNumbers.size()).isEqualTo(numberSize);
    }
}