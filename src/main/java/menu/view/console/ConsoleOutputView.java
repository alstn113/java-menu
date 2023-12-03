package menu.view.console;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.view.OutputView;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printRecommendationStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    @Override
    public void printRecommendationResult(List<Category> recommendationCategories,
                                          Map<Coach, List<String>> coachRecommendationMenus) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        String categoriesWithSeparator = recommendationCategories.stream()
                .map(Category::getName)
                .collect(Collectors.joining(" | "));
        System.out.println("[ 카테고리 | " + categoriesWithSeparator + " ]");
        coachRecommendationMenus.forEach((coach, menus) -> {
            String menusWithSeparator = String.join(" | ", menus);
            System.out.println("[ " + coach.getName() + " | " + menusWithSeparator + " ]");
        });
    }

    @Override
    public void printRecommendationEndMessage() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
