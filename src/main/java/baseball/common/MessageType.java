package baseball.common;

public enum MessageType {
    ERROR_EMPTY("[ERROR] 빈 값을 입력할 수 없습니다."),
    ERROR_ZERO("[ERROR] 0 값은 입력할 수 없습니다."),
    ERROR_NUMBER_SIZE("[ERROR] 3자리 수가 아닙니다."),
    ERROR_DUPLICATE_NUM("[ERROR] 중복된 수는 입력할 수 없습니다."),
    ERROR_NUMBER_FORMAT("[ERROR] 숫자 형식이 아닙니다."),
    ERROR_RESTART_NUMBER("[ERROR] 1 또는 2가 아닙니다."),
    INPUT_BASEBALL_NUMBER("숫자를 입력해주세요 : "),
    INPUT_RESTART_NUMBER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESULT_GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    RESULT_NOTING("낫싱");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
