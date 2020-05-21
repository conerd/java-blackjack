package view;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String NAME_JOINER = ", ";

    public static void printProgressGuide(String dealerName, List<String> playerNames) {
        String players = String.join(NAME_JOINER, playerNames);
        System.out.println(dealerName + "와 " + players + "에게 2장의 카드를 나누었습니다.");
    }

    public static void printPlayerCards(String name, String playerCards) {
        System.out.println(name + "카드: " + playerCards);
    }

    public static void printResultCardsWithScore(String playerName, String playerCards, int score) {
        System.out.println(playerName + " 카드: " +  playerCards + " - 결과: " + score);
    }

    public static void printDealerTookAdditionalCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printTakenOverScoreCard(String playerName) {
        System.out.println(playerName + "은 21을 초과하여 더이상 카드를 받지 못합니다.");
    }

    public static void printNewLine() {
        System.out.println(NEW_LINE);
    }
}