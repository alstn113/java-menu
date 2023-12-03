package menu.view.console;

import menu.view.OutputView;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printRecommendationStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    @Override
    public void printRecommendationResult() {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
    }

    @Override
    public void printRecommendationEndMessage() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
