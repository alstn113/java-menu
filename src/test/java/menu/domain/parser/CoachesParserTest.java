package menu.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Coaches;
import org.junit.jupiter.api.Test;

class CoachesParserTest {
    @Test
    void 입력값을_Coaches로_변환한다() {
        String coachNames = "코치1,코치2,코치3,코치4";
        Coaches coaches = CoachesParser.parseToCoaches(coachNames);

        List<String> coachNameList = coaches.getCoaches().stream()
                .map(Coach::getName)
                .collect(Collectors.toList());

        assertThat(coachNameList).isEqualTo(List.of("코치1", "코치2", "코치3", "코치4"));
    }
}