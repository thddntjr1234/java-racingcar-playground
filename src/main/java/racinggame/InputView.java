package racinggame;

import java.util.Scanner;

public class InputView {
    private String names;
    private int tryCount;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        names = sc.next();
        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = sc.nextInt();
        System.out.println("실행 결과");
    }

    public String getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }
}
