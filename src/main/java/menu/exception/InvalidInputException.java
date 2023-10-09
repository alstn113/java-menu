package menu.exception;

import menu.constant.ErrorMessage;

public class InvalidInputException extends AppException {
    public InvalidInputException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
