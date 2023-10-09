package menu.service;

import menu.constant.ErrorMessage;
import menu.domain.Coach;
import menu.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuService {
    private List<Coach> coaches = new ArrayList<>();

    public List<Coach> getCoachNames() {
        return coaches;
    }

    public void addCoach(String coachNames) {
        List<String> names = validateCoachLength(coachNames);
        for (String name : names) {
            coaches.add(new Coach(name));
        }
    }

    public void addAvoidMenus(Coach coach, String avoidMenus) {
        coach.setAvoidMenus(avoidMenus);
    }

    private List<String> validateCoachLength(String coachNames) {
        String[] names = coachNames.split(",");
        if (names.length < 2 || names.length > 5) {
            throw new InvalidInputException(ErrorMessage.INVALID_COACH_LENGTH);
        }

        return Arrays.asList(names);
    }
}