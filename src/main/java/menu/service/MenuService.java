package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.ErrorMessage;
import menu.domain.Category;
import menu.domain.Coach;
import menu.exception.InvalidInputException;

import java.util.*;

public class MenuService {
    private Map<Coach, List<String>> coachMenus = new LinkedHashMap<>();
    private List<Category> categories = new ArrayList<>();

    public List<Coach> getCoaches() {
        return new ArrayList<>(coachMenus.keySet());
    }

    public Map<Coach, List<String>> getCoachMenus() {
        return coachMenus;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCoach(String coachNames) {
        List<String> names = validateCoachLength(coachNames);
        for (String name : names) {
            Coach coach = new Coach(name);
            coachMenus.put(coach, new ArrayList<>());
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

    public void recommendMenu() {
        for (int days = 0; days < 5; days++) {
            Category recommendCategory = pickValidCategory();
            getCoaches().forEach(coach -> pickValidMenu(recommendCategory, coach));
        }
    }

    private Category pickValidCategory() {
        while (true) {
            int randomIndex = Randoms.pickNumberInRange(1, 5) - 1;
            Category recommendCategory = Category.values()[randomIndex];
            if (!isCategoryOverLimit(recommendCategory, 2)) {
                this.categories.add(recommendCategory);
                return recommendCategory;
            }
        }
    }

    private boolean isCategoryOverLimit(Category recommendCategory, int limit) {
        return this.categories.stream()
                .filter(category -> category.equals(recommendCategory))
                .count() >= limit;
    }

    private void pickValidMenu(Category recommendCategory, Coach coach) {
        while (true) {
            String recommendMenu = Randoms.shuffle(recommendCategory.getMenus()).get(0);
            if (!isMenuOverLimit(recommendMenu, coach, 1) && !coach.isAvoidMenu(recommendMenu)) {
                coachMenus.get(coach).add(recommendMenu);
                return;
            }
        }
    }

    private boolean isMenuOverLimit(String menu, Coach coach, int limit) {
        return coachMenus.get(coach).stream()
                .filter(m -> m.equals(menu))
                .count() >= limit;
    }

}