package domain.user;

import domain.card.CardCalculator;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends Player {
    private static final int CONDITION_ADDITIONAL_CARD = 16;

    public Dealer() {
        super("딜러", 0);
    }

    // TODO 추가 기능 구현

    public boolean isNeedAdditionalCard() {
        return (CardCalculator.calculateTotalScore(super.getScores())
                <= CONDITION_ADDITIONAL_CARD);
    }
}
