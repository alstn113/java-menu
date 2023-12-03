package menu.domain.parser;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CannotEatMenusParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"된장찌개,비빔밥,칼국수", "프렌치 토스트,바게트,스파게티", "하이라이스", ""})
    void 존재하지_메뉴인_경우(String menu) {
        assertThatNoException().isThrownBy(() -> CannotEatMenusParser.parseToCannotEatMenus(menu));

    }

    @ParameterizedTest
    @ValueSource(strings = {"된장찌개,고구마,칼국수", "스무디", "고구마"})
    void 존재하지_않는_메뉴인_경우_예외(String menu) {
        assertThatThrownBy(() -> CannotEatMenusParser.parseToCannotEatMenus(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

}