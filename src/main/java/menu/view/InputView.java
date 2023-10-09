package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.AppException;

public class InputView {
    private final OutputView outputView = new OutputView();

    public String read(String query) {
        outputView.print(query);
        return Console.readLine();
    }

    public String readCoachNames() {
        return read("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public String readAvoidMenus(String coachName) {
        return read(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName));
    }

    public void retryOnException(InputFunction inputFunction) {
        while (true) {
            try {
                inputFunction.handleInput();
                return;
            } catch (AppException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    public interface InputFunction {
        void handleInput() throws AppException;
    }
}
