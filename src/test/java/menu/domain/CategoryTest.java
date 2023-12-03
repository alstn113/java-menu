package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CategoryTest {
    @ParameterizedTest
    @ValueSource(strings = {"된장찌개", "팟타이", "나시고렝"})
    void 존재하는_메뉴일_경우(String menuName) {
        // 에러가 발생하지 않는다
        assertThatNoException().isThrownBy(() -> Category.existMenuOrThrow(menuName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"감자", "고추장", "김치"})
    void 없는_메뉴일_경우_예외(String menuName) {
        assertThatThrownBy(() -> Category.existMenuOrThrow(menuName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}