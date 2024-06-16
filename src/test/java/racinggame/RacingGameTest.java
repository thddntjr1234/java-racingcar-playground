package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

  private Car car;
  private Cars cars;

  @BeforeEach
  void init() {
    car = new Car("pobi");
    cars = new Cars(Arrays.asList("pobi", "crong", "homux"));
  }

  @Test
  void 자동차_목록_생성시_특정_글자수를_초과하면_에러_발생() {
    // 5글자 제한
    assertThatThrownBy(() -> new Cars(Arrays.asList("pbi", "croong", "homux"))).isInstanceOf(RuntimeException.class);
  }

  @Test
  void 자동차_전진_성공() {
    int previousPos = car.getPos();
    car.move(6);

    int currentPos = car.getPos();
    assertThat(previousPos).isNotEqualTo(currentPos);
  }

  @Test
  void 자동차_전진_실패() {
    int previousPos = car.getPos();
    car.move(3);

    int currentPos = car.getPos();
    assertThat(previousPos).isEqualTo(currentPos);
  }

  @Test
  void 승자가_두명_이상인_경우() {
    int repeatCount = 2;
    List<Car> childCars = cars.getCars();

    for (Car childCar : childCars) {
      childCar.move(4);
    }

    PlayResult result = new PlayResult(cars);
    Cars winners = result.judge();

    assertThat(winners.getCars().size()).isEqualTo(3);
  }

  @Test
  void 승자가_한명인_경우() {
    int repeatCount = 2;
    List<Car> childCars = cars.getCars();

    int distance = 4;
    for (Car childCar : childCars) {
      childCar.move(distance++);
    }

    PlayResult result = new PlayResult(cars);
    Cars winners = result.judge();

    assertThat(winners.getCars().size()).isEqualTo(1);
  }
}
