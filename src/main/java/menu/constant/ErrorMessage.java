package menu.constant;

public enum ErrorMessage {

    INPUT_NOT_A_NUMBER("숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
