package menu.view;

public class InputView {
    private final OutputView outputView = new OutputView();

    public String read(String query) {
        outputView.print(query);
        return System.console().readLine();
    }

    public String readCoachNames() {
        return read("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public String readAvoidMenus(String coachName) {
        return read(String.format("%s 코치가 피하고 싶은 메뉴를 입력해 주세요. (, 로 구분)", coachName));
    }
}
