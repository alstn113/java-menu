package menu.view;

import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;

public interface OutputView {
    void printRecommendationStartMessage();

    void printRecommendationResult(List<Category> recommendationCategories,
                                   Map<Coach, List<String>> coachRecommendationMenus);

    void printRecommendationEndMessage();
}
