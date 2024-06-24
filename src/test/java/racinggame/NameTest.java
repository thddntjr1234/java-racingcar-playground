package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void 생성() {
        Name name = new Name("crong");
        Assertions.assertThat(name.getName()).isEqualTo("crong");
    }

    @Test
    void 이름길이_초과_제한() {
        Assertions.assertThatThrownBy(() -> new Name("crooong")).isInstanceOf(IllegalArgumentException.class);
    }
}
