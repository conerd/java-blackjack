import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Players;
import view.InputView;
import view.OutputView;

import java.util.*;

public class BlackJackGame {
    private static final int FIRST_DISTRIBUTION_COUNT = 2;

    private static final int INDEX_FROM_DEALER = 0;
    private static final int INDEX_FROM_PLAYER = 1;
    private static final int INDEX_DEALER = 0;

    private static final String ANSWER_NO = "n";

    private static Queue<Card> cards = new LinkedList<>();
    private static Players players;

    public BlackJackGame() {
        initCards();
        players = new Players(InputView.inputPlayerNames());
    }

    private void initCards() {
        List<Card> initialCards = new ArrayList<>(CardFactory.create());
        Collections.shuffle(initialCards);

        for (Card card : initialCards) {
            cards.offer(card);
        }
    }

    public void run() {
        distributeCards();
        OutputView.printProgressGuide(players.getPlayerName(INDEX_DEALER), players.getPlayerNames());
        showPlayersCards();
        takeAdditionalCards();
        takeDealerAdditionalCards();
        showResultCardsWithScore();
    }

    private void distributeCards() {
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            distributeCardToPlayerTwice(i);
        }
    }

    private void distributeCardToPlayerTwice(int player) {
        for (int i = 0; i < FIRST_DISTRIBUTION_COUNT; i++) {
            players.distributeCardToPlayer(player, cards.poll());
        }
    }

    private void showPlayersCards() {
        for (int i = INDEX_FROM_DEALER; i < players.getNumberOfPlayers(); i++) {
            OutputView.printPlayerCards(players.getPlayerName(i), players.getPlayerCards(i));
        }
    }

    private void takeAdditionalCards() {
        for (int i = INDEX_FROM_PLAYER; i < players.getNumberOfPlayers(); i++) {
            takeAdditionalCardAsMuchAsPlayerWant(i);
        }
    }

    private void takeAdditionalCardAsMuchAsPlayerWant(int player) {
        if (!players.isNeedAdditionalCard(player)) {
            OutputView.printTakenOverScoreCard(players.getPlayerName(player));
            return;
        }

        if (InputView.inputTakingAdditionalCard(players.getPlayerName(player)).equals(ANSWER_NO)) {
            return;
        }

        players.distributeCardToPlayer(player, cards.poll());
        OutputView.printPlayerCards(players.getPlayerName(player), players.getPlayerCards(player));

        takeAdditionalCardAsMuchAsPlayerWant(player);
    }

    private void takeDealerAdditionalCards() {
        while(players.isNeedAdditionalCard(INDEX_DEALER)) {
            OutputView.printDealerTookAdditionalCard();
            players.distributeCardToPlayer(INDEX_DEALER, cards.poll());
        }
    }

    private void showResultCardsWithScore() {
        for (int i = INDEX_FROM_DEALER; i < players.getNumberOfPlayers(); i++) {
            OutputView.printResultCardsWithScore(players.getPlayerName(i), players.getPlayerCards(i), players.getScore(i));
        }
    }
}
