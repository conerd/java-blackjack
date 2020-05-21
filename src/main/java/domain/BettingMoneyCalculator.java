package domain;

import java.util.ArrayList;
import java.util.List;

public class BettingMoneyCalculator {
    private static final int BLACKJACK = 21;

    private static final Double INITIAL_MONEY = 0.0;

    private static final int MINUS = -1;
    private static final double MULTIPLE = 1.5;

    private static final int INDEX_DEALER = 0;
    private static final int INDEX_FROM_PLAYER = 1;

    private final int dealerScore;
    private List<Double> bettings = new ArrayList<>();

    public BettingMoneyCalculator(int dealerScore) {
        this.dealerScore = dealerScore;
        bettings.add(INITIAL_MONEY);
    }

    public void calculateBettingMoney(int score, double bettingMoney) {
        if (dealerScore > BLACKJACK) {
            bettings.add(bettingMoney);
            return;
        }

        if (dealerScore == BLACKJACK) {
            compareWithBlackJack(score, bettingMoney);
            return;
        }

        compareWithDealer(score, bettingMoney);
    }

    private void compareWithBlackJack(int score, double bettingMoney) {
        if (score != BLACKJACK) {
            bettingMoney *= MINUS;
        }
        bettings.add(bettingMoney);
    }

    private void compareWithDealer(int score, double bettingMoney) {
        if (score == BLACKJACK) {
            bettings.add(MULTIPLE * bettingMoney);
            return;
        }

        if (score > BLACKJACK) {
            bettings.add(MINUS * bettingMoney);
            return;
        }

        compareWhoIsCloserToBlackJack(score, bettingMoney);
    }

    private void compareWhoIsCloserToBlackJack(int score, double bettingMoney) {
        if (dealerScore == score) {
            bettings.add(INITIAL_MONEY);
            return;
        }

        if (score < dealerScore) {
            bettingMoney *= MINUS;
        }

        bettings.add(bettingMoney);
    }

    public void calculateDealerMoney() {
        double dealerMoney = 0;
        for (int i = INDEX_FROM_PLAYER; i < bettings.size(); i++) {
            dealerMoney -= bettings.get(i);
        }
        bettings.set(INDEX_DEALER, dealerMoney);
    }

    public double getBettingMoney(int player) {
        return bettings.get(player);
    }
}
