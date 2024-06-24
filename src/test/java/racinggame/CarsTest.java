package racinggame;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 승자가_한명() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 1);
        Car homux = new Car("homux", 1);
        Cars cars = new Cars(Arrays.asList(pobi, crong, homux));

        List<Car> winners = cars.getWinners();
        Assertions.assertThat(winners).containsExactly(pobi);
    }

    @Test
    void 승자가_두명_이상() {
        Car pobi = new Car("pobi", 0);
        Car crong = new Car("crong", 1);
        Car homux = new Car("homux", 1);
        Cars cars = new Cars(Arrays.asList(pobi, crong, homux));

        List<Car> winners = cars.getWinners();
        Assertions.assertThat(winners).containsExactly(crong, homux);
    }
}
