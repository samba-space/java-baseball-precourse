package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResultVO;
import baseball.view.InputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaseballServiceTest {
    @Spy
    @InjectMocks
    private BaseballService baseballService;

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

    @Test
    void 게임_플레이_정상() {
        //given
        BaseballNumber userNumbers = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballResultVO result = new BaseballResultVO(0, 0);
        MockedStatic<InputView> inputView = Mockito.mockStatic(InputView.class);

        //when
        when(baseballService.createNonDuplicateNumbers()).thenReturn(Arrays.asList(1, 2, 3));
        inputView.when(() -> InputView.input()).thenReturn(userNumbers);

        //then
        assertThatCode(() -> baseballService.play()).doesNotThrowAnyException();
    }
}