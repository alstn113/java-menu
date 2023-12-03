package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachesTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void 정상적인_생성(int coachCount) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < coachCount; i++) {
            coaches.add(new Coach("코치" + i));
        }

        Coaches Coaches = new Coaches(coaches);
        assertThat(Coaches.getCoaches()).hasSize(coachCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 6, 10})
    void 코치의_수가_2이상_5이하가_아닐_경우_예외(int coachCount) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < coachCount; i++) {
            coaches.add(new Coach("코치" + i));
        }

        assertThatThrownBy(() -> new Coaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }
}