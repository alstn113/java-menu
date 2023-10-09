package menu.view;

import menu.domain.Category;
import menu.domain.Coach;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void print(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        print(message);
    }

    public void printStartMessage() {
        print("점심 메뉴 추천을 시작합니다.");
    }

    public void printMenuRecommendation(Map<Coach, List<String>> coachMenus, List<Category> categories) {
        print("메뉴 추천 결과입니다.");
        print("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        // 카테고리 출력
        String categoryNamesWithSeperator = categories.stream().map(Category::getName).collect(Collectors.joining(" | "));
        print("[ 카테고리 | " + categoryNamesWithSeperator + " ]");

        // 각 코치의 메뉴 출력
        coachMenus.forEach((coach, menus) -> {
            String menusWithSeperator = menus.stream().collect(Collectors.joining(" | "));
            print("[ " + coach.getName() + " | " + menusWithSeperator + " ]");
        });
    }


    public void printEndMessage() {
        print("");
        print("추천을 완료했습니다.");
    }


}
