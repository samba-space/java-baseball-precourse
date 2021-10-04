package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumberTest {

    @DisplayName("정상 baseballNumbers 입력 시 BaseBallNumber 가 생성된다.")
    @Test
    void 정상_numbers_입력() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        //when, then
        assertThatCode(() -> new BaseballNumber(numbers)).doesNotThrowAnyException();
    }

    @DisplayName("baseballNumbers null 또는 empty 입력 시 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void null_empty_numbers_입력_예외발생(List<Integer> numbers) {
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] baseballNumbers 가 빈 값 입니다.");
    }

    @DisplayName("baseballNumber 로 0을 입력 시 IllegalArgumentException 이 발생한다.")
    @Test
    void 숫자_0_입력_예외발생() {
        //given
        List<Integer> numbers = Arrays.asList(0, 1, 2);
        //when, then
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 0은 baseballNumber 가 아닙니다.");
    }

    @DisplayName("baseballNumber 가 3자리 수가 아닐 경우 IllegalArgumentException 이 발생한다.")
    @Test
    void 세자리수_아닌_입력_예외발생() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2);
        //when, then
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리 수가 아닙니다.");
    }

    @DisplayName("baseballNumber 가 중복될 경우 IllegalArgumentException 이 발생한다.")
    @Test
    void 중북_숫자_입력_예외발생() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 2);
        //when, then
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 수는 입력할 수 없습니다.");
    }
}
