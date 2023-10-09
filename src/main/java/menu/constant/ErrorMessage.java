package menu.constant;

public enum ErrorMessage {

    INVALID_NAME_LENGTH("이름은 2~4자 이내로 입력해주세요."),
    INVALID_AVOID_MENU_LENGTH("못 먹는 메뉴는  최소 0개, 최대 2개까지만 입력 가능합니다."),
    INPUT_MENU_DUPLICATION("중복된 메뉴가 입력되었습니다."),
    INVALID_COACH_LENGTH("코치는 2~5명 이내로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
