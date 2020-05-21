package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ANSWER_YES = "y";
    private static final String ANSWER_NO = "n";
    private static final String NEW_LINE = "\n";

    public static String inputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        return scanner.nextLine();
    }

    public static double inputBettingMoney(String name) {
        System.out.println(NEW_LINE + name + "의 배팅 금액은?");

        return Double.parseDouble(scanner.nextLine());
    }

    public static String inputTakingAdditionalCard(String name) {
        System.out.println(NEW_LINE + name + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");

        String input = scanner.nextLine();
        while(!isValidAnswer(input)) {
            System.out.println("예는 y, 아니오는 n로 입력해주세요.");
            input = scanner.nextLine();
        }

        return input;
    }

    private static boolean isValidAnswer(String input) {
        return (input.equals(ANSWER_YES) || input.equals(ANSWER_NO));
    }


}
