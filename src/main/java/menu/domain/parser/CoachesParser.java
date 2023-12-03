package menu.domain.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Coaches;

public class CoachesParser {
    private static final String COACH_NAME_DELIMITER = ",";

    private CoachesParser() {
    }

    public static Coaches parseToCoaches(String coachNames) {
        List<Coach> coaches = Arrays.stream(coachNames.split(COACH_NAME_DELIMITER, -1))
                .map(String::trim)
                .map(Coach::new)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }
}
