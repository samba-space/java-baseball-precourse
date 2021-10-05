package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("컴퓨터 number 와 사용자 number 를 매치했을 때, Strike, Ball count 가 리턴된다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,1,1", "1,4,5,0,1", "6,7,1,0,2", "2,1,6,1,0", "7,1,3,3,0"})
    void 사용자_컴퓨터_숫자_매치(int userNum1, int userNum2, int userNum3, int strike, int ball) {
        //given
        BaseballNumber computerNumbers = new BaseballNumber(Arrays.asList(7, 1, 3));
        BaseballNumber userNumbers = new BaseballNumber(Arrays.asList(userNum1, userNum2, userNum3));
        BaseballResultVO expectedResult = new BaseballResultVO(strike, ball);

        //when
        BaseballResultVO result = computerNumbers.matchBaseballNumber(userNumbers);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}