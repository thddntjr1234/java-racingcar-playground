package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void 전진() {
        Position position = new Position(3);
        position.move();
        Assertions.assertThat(position.getPosition()).isEqualTo(4);
    }

    @Test
    void 생성() {
        Position position = new Position(3);
        Assertions.assertThat(position.getPosition()).isEqualTo(3);
    }
}
