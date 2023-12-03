package menu.exception;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력값이 숫자가 아닙니다."),
    INVALID_COACH_NAME_LENGTH("코치 이름은 2글자 이상 4글자 이하만 가능합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
