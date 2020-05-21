package domain.card;

import java.util.Collections;
import java.util.List;

public class CardCalculator {
    private static final int CONDITION_BLACKJACK = 21;

    private static final int ACE_ONE = 1;
    private static final int ACE_ELEVEN = 11;

    public static int calculateTotalScore(List<Integer> scores) {
        int sum = 0;

        Collections.sort(scores);
        Collections.reverse(scores);

        for (Integer score : scores) {
            sum += calculateScore(score.intValue(), sum);
        }

        return sum;
    }

    private static int calculateScore(int score, int sum) {
        if (score != Symbol.ACE.getScore()) {
            return score;
        }

        return getOptimalAceScore(sum);
    }

    private static int getOptimalAceScore(int sum) {
        if (Math.abs(sum + ACE_ONE - CONDITION_BLACKJACK) < Math.abs(sum + ACE_ELEVEN - CONDITION_BLACKJACK)) {
            return ACE_ONE;
        }

        return ACE_ELEVEN;
    }
}
