package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        Position maxPosition = getMaxPosition();

        List<Car> winners = cars.stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());
        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
