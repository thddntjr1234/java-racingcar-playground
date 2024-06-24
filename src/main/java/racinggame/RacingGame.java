package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        // input
        InputView inputView = new InputView();
        inputView.input();

        String[] names = inputView.getNames().split(",");
        int tryCount = inputView.getTryCount();

        List<Car> carsConstructorParams = new ArrayList<>();
        for (String name : names) {
            carsConstructorParams.add(new Car(name));
        }

        Cars cars = new Cars(carsConstructorParams);
        OutputView outputView = new OutputView();

        while (tryCount != 0) {
            tryCount--;
            cars.race();
            outputView.printRaceResult(cars);
        }

        // 결과 출력
        List<Car> winners = cars.getWinners();
        outputView.printWinners(winners);
    }
}
