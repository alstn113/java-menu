package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.exception.ErrorMessage;
import menu.exception.InvalidInputException;

public class Coaches {
    private static final int MIN_COACH_SIZE = 2;
    private static final int MAX_COACH_SIZE = 5;
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoachCount(coaches);
        this.coaches = new ArrayList<>(coaches);
    }

    private void validateCoachCount(List<Coach> coaches) {
        int coachCount = coaches.size();
        if (coachCount < MIN_COACH_SIZE || coachCount > MAX_COACH_SIZE) {
            throw new InvalidInputException(ErrorMessage.INVALID_COACH_SIZE);
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
