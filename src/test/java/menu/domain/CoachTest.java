package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {
    @ParameterizedTest
    @ValueSource(strings = {"aa", "bbb", "aaaa"})
    void 정상적인_코치를_생성한다(String name) {
        Coach coach = new Coach(name);
        assertThat(coach.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "aaaaa"})
    void 코치의_이름은_2자_이상_4자_이하만_가능하다(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}