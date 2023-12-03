package menu.domain.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;

public class CannotEatMenusParser {
    private static final String COACH_NAME_DELIMITER = ",";

    private CannotEatMenusParser() {
    }

    public static List<String> parseToCannotEatMenus(String cannotEatMenus) {
        if (cannotEatMenus.isBlank()) {
            return List.of();
        }
        List<String> menus = Arrays.stream(cannotEatMenus.split(COACH_NAME_DELIMITER, -1))
                .map(String::trim)
                .collect(Collectors.toList());

        menus.forEach(Category::existMenuOrThrow);

        return menus;
    }
}

