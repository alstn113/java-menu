package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.exception.ErrorMessage;
import menu.exception.InvalidInputException;

public class Coach {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private final String name;
    private List<String> cannotEatMenus = new ArrayList<>();

    public Coach(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        int nameLength = name.length();
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new InvalidInputException(ErrorMessage.INVALID_COACH_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getCannotEatMenus() {
        return cannotEatMenus;
    }

    public void setCannotEatMenus(List<String> cannotEatMenus) {
        this.cannotEatMenus = new ArrayList<>(cannotEatMenus);
    }
}
