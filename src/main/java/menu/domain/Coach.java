package menu.domain;

import menu.constant.ErrorMessage;
import menu.exception.InvalidInputException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coach {
    private String name;
    private Set<String> avoidMenus = new HashSet<>();

    public Coach(String name) {
        this.name = name;
        validate(name);
    }

    public String getName() {
        return name;
    }

    public Set<String> getAvoidMenus() {
        return avoidMenus;
    }

    public void setAvoidMenus(String input) {
        List<String> menus = validateAvoidMenu(input);

        this.avoidMenus.clear();
        this.avoidMenus.addAll(menus);
    }

    private void validate(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new InvalidInputException(ErrorMessage.INVALID_NAME_LENGTH);
        }
    }

    private List<String> validateAvoidMenu(String input) {
        String[] menus = input.split(",");

        if (menus.length > 2) {
            throw new InvalidInputException(ErrorMessage.INVALID_AVOID_MENU_LENGTH);
        }

        if (Arrays.stream(menus).distinct().count() < menus.length) {
            throw new InvalidInputException(ErrorMessage.INPUT_MENU_DUPLICATION);
        }

        return Arrays.asList(menus);
    }
}


