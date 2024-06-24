package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 전진_성공(int randomNum) {
        Car car = new Car("homux", 0);
        car.move(randomNum);

        Assertions.assertThat(car.getPosition().getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 전진_실패(int randomNum) {
        Car car = new Car("homux", 0);
        car.move(randomNum);

        Assertions.assertThat(car.getPosition().getPosition()).isEqualTo(0);
    }
}
