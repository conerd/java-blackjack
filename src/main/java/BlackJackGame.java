import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Players;
import view.InputView;
import view.OutputView;

import java.util.*;

public class BlackJackGame {
    private static final int DEALER_NUMBER = 0;
    private static final int FIRST_DISTRIBUTION_COUNT = 2;

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
        splitCards();
        OutputView.printProgressGuide(players.getPlayerName(DEALER_NUMBER), players.getPlayerNames());
        showPlayersCards();
    }

    private void splitCards() {
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            distributeCardTwice(i);
        }
    }

    private void distributeCardTwice(int player) {
        for (int i = 0; i < FIRST_DISTRIBUTION_COUNT; i++) {
            players.distributeCardToPlayer(player, cards.poll());
        }
    }

    private void showPlayersCards() {
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            OutputView.printPlayerCards(players.getPlayerName(i), players.getPlayerCards(i));
        }
    }
}
