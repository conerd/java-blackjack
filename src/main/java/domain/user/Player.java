package domain.user;

import domain.card.Card;
import domain.card.CardCalculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private static final int CONDITION_DEALER_ADDITIONAL_CARD = 21;

    private final String name;
    private final double bettingMoney;

    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public double getBettingMoney() {
        return this.bettingMoney;
    }

    public String getCardsNames() {
        List<String> cardStrings = new LinkedList<>();
        for (Card card : cards) {
            cardStrings.add(card.toString());
        }

        return String.join(", ", cardStrings);
    }

    public List<Integer> getScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card card : cards) {
            scores.add(card.getScore());
        }

        return scores;
    }

    public int getScore() {
        return CardCalculator.calculateTotalScore(getScores());
    }

    public boolean isNeedAdditionalCard() {
        return (getScore() <= CONDITION_DEALER_ADDITIONAL_CARD);
    }
}
