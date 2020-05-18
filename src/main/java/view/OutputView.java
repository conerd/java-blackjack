package view;

import java.util.List;

public class OutputView {
    public static void printProgressGuide(String dealerName, List<String> playerNames) {
        String players = String.join(", ", playerNames);

        System.out.println("\n" + dealerName + "와 " + players + "에게 2장의 카드를 나누었습니다.");
    }

    public static void printPlayerCards(String name, String playerCards) {
        System.out.println(name + "카드: " + playerCards);
    }
}
