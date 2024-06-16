package racinggame;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class PlayResult {
  private Cars cars;
  private int maxDistance = 0;

  public PlayResult(Cars cars) {
    this.cars = cars;
    maxDistance = 0;
  }

  public Cars judge() {
    maxDistance = cars.getCars().stream()
        .mapToInt(Car::getPos)
        .max()
        .orElseThrow(NoSuchElementException::new);

    List<Car> winners = cars.getCars().stream()
        .peek(this::isCarWinner)
        .filter(Car::isWinner)
        .collect(Collectors.toList());

    Cars result = new Cars();
    for (Car car : winners) {
      result.addCar(car);
    }

    return result;
  }

  private void isCarWinner(Car car) {
    if (maxDistance == car.getPos()) {
      car.win();
    }
  }
}
