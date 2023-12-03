package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.exception.ErrorMessage;
import menu.exception.InvalidInputException;

public class CoachMealGroup {
    private static final int MIN_COACHES = 2;
    private static final int MAX_COACHES = 5;
    private final List<Coach> coaches;

    public CoachMealGroup(List<Coach> coaches) {
        validateCoachCount(coaches);
        this.coaches = new ArrayList<>(coaches);
    }

    private void validateCoachCount(List<Coach> coaches) {
        int coachCount = coaches.size();
        if (coachCount < MIN_COACHES || coachCount > MAX_COACHES) {
            throw new InvalidInputException(ErrorMessage.INVALID_COACH_COUNT);
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
