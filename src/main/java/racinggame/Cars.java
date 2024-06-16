package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(List<String> carName) {
    List<Car> tempCars = new ArrayList<>();

    for (String name : carName) {
      tempCars.add(new Car(name));
    }

    this.cars = tempCars;
  }

  public Cars() {
    cars = new ArrayList<>();
  }

  public void addCar(Car car) {
    this.cars.add(car);
  }

  public List<Car> getCars() {
    return this.cars;
  }

}
