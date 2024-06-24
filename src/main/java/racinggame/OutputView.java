package racinggame;

import java.util.List;

public class OutputView {
    public void printRaceResult(Cars raceCars) {
        List<Car> cars = raceCars.getCars();

        for (Car car : cars) {
            Name name = car.getName();
            String distance = makeDistanceStr(car);

            String content = "%s : %s";

            System.out.println(String.format(content, name.getName(), distance));
        }
        System.out.println("");
    }

    private String makeDistanceStr(Car car) {
        Position position = car.getPosition();
        String result = "";
        for (int i = 0; i < position.getPosition(); i++) {
            result += "-";
        }

        return result;
    }

    public void printWinners(List<Car> winners) {
        String winnersStr = "";
        for (int i = 0; i < winners.size(); i++) {
            winnersStr += winners.get(i).getName().getName();
            if (i != winners.size() - 1) {
                winnersStr += ", ";
            }
        }
        winnersStr += "가 최종 우승했습니다.";
        System.out.print(winnersStr);
     }
}
