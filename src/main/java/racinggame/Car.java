package racinggame;

import java.util.Random;

public class Car {
    public static final int MIN_MOVE_CONDITION = 4;
    public static final int RANDOM_BOUND = 10;

    private Name name;
    private Position position;

    public Car(String driverName, int position) {
        this.name = new Name(driverName);
        this.position = new Position(position);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void move(int randomNum) {
        if (isMovable(randomNum)) {
            position.move();
        }
    }

    public void move() {
        // random값 구해서 이동
        if (isMovable(getRandomNum())) {
            position.move();
        }
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    private boolean isMovable(int randomNum) {
        if (randomNum >= MIN_MOVE_CONDITION) {
            return true;
        }

        return false;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.isGreaterThan(maxPosition)) {
            return position;
        }

        return maxPosition;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

}
