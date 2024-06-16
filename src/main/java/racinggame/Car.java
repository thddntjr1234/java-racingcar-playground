package racinggame;

import java.util.Random;

public class Car {
  private String name;
  private int pos = 0;
  private boolean isWinner = false;

  private final int MAX_CAR_NAME_LENGTH = 5;
  private final int MIN_MOVABLE_DISTANCE = 4;

  public Car(String name) {
    validateNameLength(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getPos() {
    return pos;
  }

  public boolean isWinner() {
    return isWinner;
  }

  private void validateNameLength(String name) {
    if (name.length() > MAX_CAR_NAME_LENGTH) {
      throw new RuntimeException("자동차 이름 길이 제한을 초과했습니다.");
    }
  }

  public void play() {
    int nextDistance = getNextDistance();
    move(nextDistance);
  }

  // move, getNextDistance()는 play() 하위 메서드이나, 단위 기능에 해당하기 때문에 테스트를 위해 private이 아닌 default 접근자로 선언한다.
  void move(int nextDistance) {
   if (MAX_CAR_NAME_LENGTH <= nextDistance) {
     this.pos += nextDistance;
   }
  }

  int getNextDistance() {
    Random random = new Random();
    return random.nextInt(10);
  }

  void win() {
    this.isWinner = true;
  }
}
