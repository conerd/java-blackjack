package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        return scanner.nextLine();
    }

    public static double inputBettingMoney(String name) {
        System.out.println("\n" + name + "의 배팅 금액은?");

        return scanner.nextDouble();
    }
}
