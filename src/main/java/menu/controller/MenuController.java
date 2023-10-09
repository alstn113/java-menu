package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 시작 메세지
        outputView.printStartMessage();

        // 코치의 이름들을 읿력
        String coachNames = inputView.readCoachNames();

        // 코치들이 못 먹는 메뉴를 입력
        for (String coachName : coachNames.split(",")) {
            String avoidMenus = inputView.readAvoidMenus(coachName);
        }

        // 메뉴 추천 결과 출력
        outputView.printMenuRecommendation();

        // 종료 메세지
        outputView.printEndMessage();
    }
}
