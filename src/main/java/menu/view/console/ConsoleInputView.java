package menu.view.console;

import camp.nextstep.edu.missionutils.Console;
import menu.view.InputView;

public class ConsoleInputView implements InputView {
    @Override
    public String readCoachNames() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    @Override
    public String readCannotEatMenusForCoach(String coachName) {
        System.out.println();
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coachName);
        return Console.readLine();
    }
}
