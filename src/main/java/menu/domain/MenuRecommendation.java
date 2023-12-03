package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendation {
    private static final int MAX_CATEGORY_COUNT = 2;
    private static final int MAX_MENU_COUNT = 1;
    private final List<Category> recommendCategories = new ArrayList<>();
    private final Map<Coach, List<String>> coachMenus = new LinkedHashMap<>();

    public MenuRecommendation(Coaches coaches) {
        recommend(coaches);
    }

    private void recommend(Coaches coaches) {
        coaches.getCoaches().forEach(coach -> coachMenus.put(coach, new ArrayList<>()));

        for (int i = 0; i < 5; i++) {
            Category category = pickCategory();
            coaches.getCoaches().forEach(coach -> pickMenu(coach, category));
        }
    }

    private Category pickCategory() {
        while (true) {
            int categoryIndex = Randoms.pickNumberInRange(1, 5) - 1;
            List<Category> categories = Arrays.asList(Category.values());
            Category category = categories.get(categoryIndex);
            if (!isCategoryOverMaxCount(category)) {
                recommendCategories.add(category);
                return category;
            }
        }
    }

    private boolean isCategoryOverMaxCount(Category category) {
        return recommendCategories.stream()
                .filter(c -> c.equals(category))
                .count() >= MAX_CATEGORY_COUNT;
    }

    private void pickMenu(Coach coach, Category category) {
        while (true) {
            String menu = Randoms.shuffle(category.getMenus()).get(0);
            if (!isMenuOverMaxCount(coach, menu) && !coach.getCannotEatMenus().contains(menu)) {
                coachMenus.get(coach).add(menu);
                return;
            }
        }
    }

    private boolean isMenuOverMaxCount(Coach coach, String menu) {
        return coachMenus.get(coach).stream()
                .filter(m -> m.equals(menu))
                .count() >= MAX_MENU_COUNT;
    }

    public List<Category> getRecommendationCategories() {
        return recommendCategories;
    }

    public Map<Coach, List<String>> getCoachRecommendationMenus() {
        return coachMenus;
    }
}
