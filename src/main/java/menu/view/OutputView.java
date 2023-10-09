package menu.view;

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

    public void printMenuRecommendation() {
        print("메뉴 추천 결과입니다.");
    }

    public void printEndMessage() {
        print("추천을 완료했습니다.\n");
    }


}
